package com.tinqinacademy.hotel.api.errors;

import org.springframework.http.HttpStatus;

public interface ErrorsWrapper {

    void addError(OperationError error);

    HttpStatus getStatus();

}
