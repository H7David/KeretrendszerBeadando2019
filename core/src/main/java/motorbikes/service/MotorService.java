package motorbikes.service;

import motorbikes.exception.*;
import motorbikes.model.Motor;

import java.util.Collection;





public interface MotorService {

    Collection<Motor> listAllMotors();
    Motor getMotor(String rendszam) throws RosszRendszam, MotorNemTalalhato;
    void addMotor(Motor motor)throws  RosszDatum,RosszEvjarat,RosszRendszam,RendszamMarFoglalt;

    void deleteMotor(Motor motor) throws MotorNemTalalhato;

    Collection<Motor> listAllMotorsByManufacturer(String manufacturer);


    void updateMotor(Motor motor) throws MotorNemTalalhato;

}
