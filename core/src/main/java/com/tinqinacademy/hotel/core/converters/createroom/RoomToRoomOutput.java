package com.tinqinacademy.hotel.core.converters.createroom;

import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomOutput;
import com.tinqinacademy.hotel.persistence.entities.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomToRoomOutput implements Converter<Room, CreateRoomOutput> {

    @Override
    public CreateRoomOutput convert(Room source) {
        return CreateRoomOutput
                .builder()
                .id(source.getId())
                .build();
    }
}
