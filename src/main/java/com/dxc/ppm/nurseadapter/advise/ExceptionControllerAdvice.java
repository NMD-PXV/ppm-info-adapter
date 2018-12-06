package com.dxc.ppm.nurseadapter.advise;

import com.dxc.ppm.nurseadapter.exception.PersonalInfoException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(PersonalInfoException.class)
    public ResponseEntity<String> personalInfoExceptionHandle(PersonalInfoException ex) {
        String message = ex.getResponse().name();
        return new ResponseEntity<>(message, ex.getResponse().getHttpStatus());
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> jsonExceptionHandle(JsonProcessingException ex){
        return new ResponseEntity<>("JSON parse failed", HttpStatus.BAD_REQUEST);
    }

}
