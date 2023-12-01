package com.csi.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class validation extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fildname = ((FieldError)error).getField();
            String fildmsg = error.getDefaultMessage();
            errors.put(fildname,fildmsg);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
