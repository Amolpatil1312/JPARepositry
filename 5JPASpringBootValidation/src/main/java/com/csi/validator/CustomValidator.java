package com.csi.validator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class CustomValidator extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> error = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String fild = ((FieldError)error).getField();
            String fieldmsg = ((FieldError) error).getDefaultMessage();
            error.put(fild,fieldmsg);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
