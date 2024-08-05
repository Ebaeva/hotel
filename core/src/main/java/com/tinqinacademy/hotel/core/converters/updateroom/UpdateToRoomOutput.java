package com.tinqinacademy.hotel.core.converters.updateroom;

import com.tinqinacademy.hotel.api.operation.editroom.EditRoomOutput;
import com.tinqinacademy.hotel.persistence.entities.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateToRoomOutput implements Converter<Room, EditRoomOutput> {

    @Override
    public EditRoomOutput convert(Room source) {
        return EditRoomOutput
                .builder()
                .id(source.getId())
                .build();
    }
}
