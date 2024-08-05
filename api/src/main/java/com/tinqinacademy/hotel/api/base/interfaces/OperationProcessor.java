package com.tinqinacademy.hotel.api.base.interfaces;

import com.tinqinacademy.hotel.api.errors.Errors;
import io.vavr.control.Either;

public interface OperationProcessor<O extends OperationOutput, I extends OperationInput> {
    Either<Errors, O> process(I input);
}
