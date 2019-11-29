package motorbikes.dao;

import motorbikes.exception.MotorNemTalalhato;
import motorbikes.exception.RendszamMarFoglalt;
import motorbikes.exception.RosszRendszam;
import motorbikes.model.Motor;

import java.util.Collection;

public interface MotorDAO {
Collection<Motor> readAllMotors();
Motor readMotor(String rendszam) throws RosszRendszam, MotorNemTalalhato;

     void insertMotor(Motor motor) throws RendszamMarFoglalt, RosszRendszam;

     void updateMotor(Motor motor) throws MotorNemTalalhato;

     void deleteMotor(Motor motor) throws MotorNemTalalhato;



}
