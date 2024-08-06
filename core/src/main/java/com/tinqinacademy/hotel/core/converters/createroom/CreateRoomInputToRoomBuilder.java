package com.tinqinacademy.hotel.core.converters.createroom;

import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomInput;
import com.tinqinacademy.hotel.persistence.entities.Room;
import com.tinqinacademy.hotel.persistence.enums.BathroomTypes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateRoomInputToRoomBuilder implements Converter<CreateRoomInput, Room.RoomBuilder> {

    @Override
    public Room.RoomBuilder convert(CreateRoomInput source) {
        return Room
                .builder()
                .roomBathroomType(BathroomTypes.getByCode(source.getBathroomType()))
                .roomFloor(source.getFloor())
                .roomNumber(source.getRoomN())
                .roomPrice(source.getPrice());

    }
}
