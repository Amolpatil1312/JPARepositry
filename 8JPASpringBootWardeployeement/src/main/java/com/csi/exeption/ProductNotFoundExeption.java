package com.csi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExeption extends RuntimeException{

    public ProductNotFoundExeption(String msg){
        super(msg);
    }
}
