package com.innov.innovrobots.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class FullCapacityException extends Exception{
    public FullCapacityException() {
        super("Full Capacity");
    }
}
