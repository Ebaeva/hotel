package com.tinqinacademy.hotel.core.exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus code;

    public BaseException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
