package com.tinqinacademy.hotel.core.converters.guest;

import com.tinqinacademy.hotel.api.models.outputs.GuestOutput;
import com.tinqinacademy.hotel.persistence.entities.Guest;
import org.springframework.core.convert.converter.Converter;

public class GuestToGuestOutput implements Converter<Guest,GuestOutput> {
    @Override
    public GuestOutput convert(Guest source) {
        return GuestOutput
                .builder()
                .cardNumber(source.getCardNumber())
                .cardIssueAuthority(source.getCardIssueAuthority())
                .cardIssueDate(source.getCardIssueDate())

                .cardValidity(source.getCardValidity())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())

                .birthDate(source.getBirthDate())
                .build();
    }
}
