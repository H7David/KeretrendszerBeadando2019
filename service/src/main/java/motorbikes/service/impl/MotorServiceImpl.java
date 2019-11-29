package motorbikes.service.impl;

import motorbikes.dao.MotorDAO;
import motorbikes.exception.*;
import motorbikes.model.Motor;
import motorbikes.dao.MotorDAO;


import java.util.ArrayList;
import java.util.Collection;

public class MotorServiceImpl {

    private MotorDAO dao;
    public MotorServiceImpl(MotorDAO dao){this.dao= dao;}
    public Collection<Motor> listAllMotors(){return dao.readAllMotors();}
    public Motor getMotor(String rendszam) throws RosszRendszam, MotorNemTalalhato{return  dao.readMotor(rendszam); }
    public void addMotor(Motor motor) throws RosszDatum, RosszEvjarat, RosszRendszam, RendszamMarFoglalt { dao.insertMotor(motor);}
    public void deleteAuto(Motor motor) throws MotorNemTalalhato { dao.deleteMotor(motor); }

    public Collection<Motor> listAllAutosByManufacturer(String manufacturer) {
        Collection<Motor> allMotor = dao.readAllMotors();
        Collection<Motor> result = new ArrayList<Motor>();
        for (Motor m: allMotor){
            if(m.getMarka().equalsIgnoreCase(manufacturer)){result.add(m); }

        }
        return result;
    }

}
