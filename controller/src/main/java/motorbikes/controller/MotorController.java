package motorbikes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MotorController {
    @RequestMapping(value = "kutya")
    public void proba(){System.out.println("Működik!!!");}
}
