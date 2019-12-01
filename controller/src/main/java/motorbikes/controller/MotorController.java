package motorbikes.controller;

import motorbikes.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MotorController {

    MotorService service;
    public  MotorController(@Autowired(required = true) MotorService service) { this.service = service; }


    @RequestMapping(value = "kutya")
    public void proba(){System.out.println("Működik!!!");}


    @RequestMapping(value = "test")
    public void testService(){ System.out.println(service.listAllMotors().size()); }
}
