package motorbikes.controller;

import motorbikes.exception.RendszamMarFoglalt;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RendszamMarFoglalt.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.IM_USED)
    public String duplikalt(RendszamMarFoglalt e){ return e.getMessage()+", nem update kellene?"; }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public String unsupoorted(){return "elfogadhato media tipusok:"+ MediaType.APPLICATION_JSON_VALUE;}
}
