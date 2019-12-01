package motorbikes.service.impl;

import motorbikes.dao.MotorDAO;
import motorbikes.exception.*;
import motorbikes.model.Motor;
import motorbikes.dao.MotorDAO;
import motorbikes.service.MotorService;


import java.util.ArrayList;
import java.util.Collection;

public class MotorServiceImpl implements MotorService {

    private MotorDAO dao;
    public MotorServiceImpl(MotorDAO dao){this.dao= dao;}
    public Collection<Motor> listAllMotors(){return dao.readAllMotors();}
    public Motor getMotor(String rendszam) throws RosszRendszam, MotorNemTalalhato{return  dao.readMotor(rendszam); }
    public void addMotor(Motor motor) throws RosszDatum, RosszEvjarat, RosszRendszam, RendszamMarFoglalt { dao.insertMotor(motor);}
    public void deleteMotor(Motor motor) throws MotorNemTalalhato { dao.deleteMotor(motor); }


    @Override
    public Collection<Motor> listAllMotorsByManufacturer(String manufacturer) {
         Collection<Motor> allMotor= dao.readAllMotors();
        Collection<Motor> result= new ArrayList<Motor>();
        for (Motor m: allMotor){ if(m.getMarka().equalsIgnoreCase(manufacturer)){result.add(m);}}
        return result;
    }

    @Override
    public void updateMotor(Motor motor) throws MotorNemTalalhato{
        dao.updateMotor(motor);
    }

}
