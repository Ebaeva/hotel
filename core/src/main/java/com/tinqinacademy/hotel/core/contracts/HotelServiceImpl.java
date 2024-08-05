package com.tinqinacademy.hotel.core.contracts;

import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedInput;
import com.tinqinacademy.hotel.api.operation.roombooked.RoomBookedInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomOutput;
import com.tinqinacademy.hotel.api.operation.getroombyid.GetRoomByIdOutput;
import com.tinqinacademy.hotel.persistence.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class HotelServiceImpl implements HotelService {
    private RoomRepository roomRepository;

    @Autowired
    public HotelServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomOutput checkRoomAvailability(RoomInput roomsInput) {
        return RoomOutput
                .builder()
                .id(List.of(Arrays.toString(new Integer[]{1, 2, 3})))
                .build();
    }

    @Override
    public GetRoomByIdOutput getRoomInfoById(String id) {
       // Room room = this.roomRepository.findById(id);

        return GetRoomByIdOutput
                .builder()
//                .id(room.getId())
//                .price(room.getPrice())
//                .floor(room.getFloor())
//                .bedCount(room.getBedCount())
//                .datesOccupied(List.of(LocalDate.now(), LocalDate.now().plusDays(1)))
                .build();
    }

    @Override
    public void roomsBooked(RoomBookedInput roomBookedInput) {

    }

    @Override
    public void deleteRoomBooked(DeleteRoomBookedInput deleteRoomBookedInput) {

    }
}
