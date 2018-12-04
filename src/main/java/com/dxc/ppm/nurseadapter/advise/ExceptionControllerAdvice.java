package com.dxc.ppm.nurseadapter.advise;

import com.dxc.ppm.nurseadapter.exception.PersonalInfoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(PersonalInfoException.class)
    public ResponseEntity<String> personalInfoExceptionHandle(PersonalInfoException ex) {
        String message = ex.getResponse().name();
        return new ResponseEntity<String>(message, ex.getResponse().getHttpStatus());
    }

}
