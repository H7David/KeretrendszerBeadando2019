package keretrendszerBeadando.dao.impl.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import motorbikes.dao.MotorDAO;
import motorbikes.exception.MotorNemTalalhato;
import motorbikes.exception.RendszamMarFoglalt;
import motorbikes.exception.RosszRendszam;
import motorbikes.model.Motor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class MotorDAOJSON implements MotorDAO {

    File jsonfile;
    ObjectMapper mapper;

    public MotorDAOJSON(String filepath) {
        jsonfile = new File(filepath);
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
                FileWriter writer = new FileWriter(jsonfile);
                writer.write("[]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Collection<Motor> readAllMotors() {
        Collection<Motor> result = new ArrayList<Motor>();
        try {
            result = mapper.readValue(jsonfile, new TypeReference<ArrayList<Motor>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Motor readMotor(String rendszam) throws RosszRendszam, MotorNemTalalhato {
        try {
            Motor motor = new Motor();
            motor.setRendszam(rendszam);
        } catch (RosszRendszam rosszRendszam) {
            throw rosszRendszam;
        }
        Collection<Motor> motors = readAllMotors();
        for(Motor motor: motors){
            if (motor.getRendszam().equalsIgnoreCase(rendszam)){
                return motor;
            }
        }
        throw new MotorNemTalalhato();
    }

    @Override
    public void insertMotor(Motor motor) throws RendszamMarFoglalt, RosszRendszam {
        try{
            readMotor(motor.getRendszam());
            throw new RendszamMarFoglalt(motor.getRendszam());
        }
        catch (MotorNemTalalhato motorNemTalalhato) {
            Collection<Motor> motors = readAllMotors();
            motors.add(motor);
            try {
                mapper.writeValue(jsonfile, motors);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    @Override
    public void updateMotor(Motor motor) throws MotorNemTalalhato {

        Collection<Motor> motors = readAllMotors();
        try {
            Motor motortorol = readMotor(motor.getRendszam());
            motors.remove(motortorol);
            motors.add(motor);
            mapper.writeValue(jsonfile, motor);
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        } catch (MotorNemTalalhato nem_talalhato){
            throw nem_talalhato;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMotor(Motor motor) throws MotorNemTalalhato {
        Collection<Motor> motors = readAllMotors();
        try {
            Motor motortorol = readMotor(motor.getRendszam());
            motors.remove(motortorol);
            mapper.writeValue(jsonfile, motors);
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        } catch (MotorNemTalalhato nem_talalhato){
            throw nem_talalhato;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
