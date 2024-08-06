package com.tinqinacademy.hotel.core.operation;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedInput;
import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedOperation;
import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedOutput;
import com.tinqinacademy.hotel.core.errorsmapper.ErrorMapper;
import com.tinqinacademy.hotel.core.exeptions.RoomNotFoundException;
import com.tinqinacademy.hotel.persistence.repository.ReservationRepository;
import io.vavr.Predicates;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static io.vavr.API.*;

@Service
@Slf4j
public class DeleteBookingOperationProcessor extends BaseOperationProcessor implements DeleteRoomBookedOperation {
    private final ReservationRepository reservationRepository;

    protected DeleteBookingOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper, ReservationRepository reservationRepository) {
        super(conversionService, validator, errorMapper);
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Either<Errors, DeleteRoomBookedOutput> process(DeleteRoomBookedInput input) {
        return Try.of(()->{
                    log.info("Start deleteBooking with id: {}", input);


                    reservationRepository.findById(UUID.fromString(input.getId()))
                            .orElseThrow(() -> new RoomNotFoundException(input.getId()));

                    reservationRepository.deleteById(UUID.fromString(input.getId()));
                    DeleteRoomBookedOutput result = DeleteRoomBookedOutput.builder().build();

                    log.info("End of deleteBooking");
                    return result;
                }).toEither()
                .mapLeft(throwable -> Match(throwable).of(
                        Case($(Predicates.instanceOf(RoomNotFoundException.class)), errorMapper::mapErrors),
                        Case($(), errorMapper::mapErrors)
                ));

    }
}
