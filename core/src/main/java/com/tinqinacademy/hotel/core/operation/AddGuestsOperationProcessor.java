package com.tinqinacademy.hotel.core.operation;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.models.inputs.GuestInput;
import com.tinqinacademy.hotel.api.operation.visitorregister.VisitorRegisterInput;
import com.tinqinacademy.hotel.api.operation.visitorregister.VisitorRegisterOperation;
import com.tinqinacademy.hotel.api.operation.visitorregister.VisitorRegisterOutput;
import com.tinqinacademy.hotel.core.errorsmapper.ErrorMapper;
import com.tinqinacademy.hotel.persistence.entities.Guest;
import com.tinqinacademy.hotel.persistence.repository.GuestRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.vavr.API.*;

@Service
@Slf4j
public class AddGuestsOperationProcessor extends BaseOperationProcessor implements VisitorRegisterOperation {
    private final GuestRepository guestRepository;

    protected AddGuestsOperationProcessor(ConversionService conversionService, Validator validator, ErrorMapper errorMapper, GuestRepository guestRepository) {
        super(conversionService, validator, errorMapper);
        this.guestRepository = guestRepository;
    }

    @Override
    public Either<Errors, VisitorRegisterOutput> process(VisitorRegisterInput input) {
        return Try.of(() -> {


                    log.info("Start registerUser input: {}", input.toString());

                    List<Guest> unknownGuests = saveUnknownGuests(input.getGuests());

                    VisitorRegisterOutput result = VisitorRegisterOutput
                            .builder()
                            .guests(unknownGuests
                                    .stream()
                                    .map(guest -> conversionService.convert(guest, GuestInput.class))
                                    .toList())
                            .build();

                    log.info("End of registerUser result: {}", result.toString());
                    return result;

                }).toEither()
                .mapLeft(throwable -> Match(throwable).of(

                        Case($(), errorMapper::mapErrors)
                ));

    }

    private List<Guest> saveUnknownGuests(List<GuestInput> guestList) {
        log.info("Start saveUnknownGuests input: {}", guestList);

        List<String> inputGuestCardNumbers = guestList.stream().map(GuestInput::getCardNumber).toList();

        List<Guest> existingGuests = guestRepository.findAllByCardNumberIn(new ArrayList<>(inputGuestCardNumbers));

        Set<String> existingGuestsCardNumbers = existingGuests
                .stream()
                .map(Guest::getCardNumber)
                .collect(Collectors.toSet());


        List<Guest> unknownGuests = guestList
                .stream()
                .filter(guestInput -> !existingGuestsCardNumbers.contains(guestInput.getCardNumber()))
                .map(guestInput -> conversionService.convert(guestInput, Guest.class))
                .toList();


        List<Guest> result = new ArrayList<>(existingGuests);

        List<Guest> savedUnknownGuests = guestRepository.saveAll(unknownGuests);

        result.addAll(savedUnknownGuests);

        log.info("End of saveUnknownGuests result: {}", result.toString());
        return result;
    }
}


