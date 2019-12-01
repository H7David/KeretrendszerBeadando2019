package motorbikes.controller;

import motorbikes.exception.*;
import motorbikes.model.Motor;
import motorbikes.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MotorController {

    MotorService service;
    public  MotorController(@Autowired(required = true) MotorService service) { this.service = service; }


    @RequestMapping(value = "kutya")
    public void proba(){System.out.println("Működik!!!");}


    @RequestMapping(value = "test")
    //public void testService(){ System.out.println(service.listAllMotors().size()); }
    @ResponseBody
    public String testService(){ return String.valueOf(service.listAllMotors().size()); }

    @RequestMapping(value = "/getMotorData/{rendszam}")
    @ResponseBody
    public Motor getMotorByRendszam(@PathVariable(value = "rendszam") String rendszam) throws MotorNemTalalhato, RosszRendszam {
        System.out.println("KUTYA");
        return service.getMotor(rendszam);
    }

    @RequestMapping(value ="addMotor", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addAuto(@RequestBody Motor motor) throws RosszDatum, RosszEvjarat, RosszRendszam, RendszamMarFoglalt { service.addMotor(motor); }





}
