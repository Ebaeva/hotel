package com.tinqinacademy.hotel.core.converters.updateroom;

import com.tinqinacademy.hotel.api.operation.editroom.EditRoomInput;
import com.tinqinacademy.hotel.persistence.entities.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditRoomInputToRoomBuilder implements Converter<EditRoomInput, Room.RoomBuilder> {

    @Override
    public Room.RoomBuilder convert(EditRoomInput source) {
        return Room
                .builder()
               // .id(UUID.fromString(source.getId()))
                .roomNumber(source.getRoomN())
                .roomFloor(source.getFloor())
                .roomPrice(source.getPrice());


    }
}
