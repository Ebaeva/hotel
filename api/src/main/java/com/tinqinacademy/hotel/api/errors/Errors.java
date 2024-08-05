package com.tinqinacademy.hotel.api.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Errors implements ErrorsWrapper {
    private List<OperationError> errors = new ArrayList<>();
    private HttpStatus status;

    @Override
    public void addError(OperationError error) {

    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}



