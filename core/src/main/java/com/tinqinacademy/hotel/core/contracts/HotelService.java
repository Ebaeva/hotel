package com.tinqinacademy.hotel.core.contracts;


import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedInput;
import com.tinqinacademy.hotel.api.operation.getroombyid.GetRoomByIdOutput;
import com.tinqinacademy.hotel.api.operation.roombooked.RoomBookedInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomOutput;

public interface HotelService {
    RoomOutput checkRoomAvailability (RoomInput roomsInput);
    GetRoomByIdOutput getRoomInfoById(String id);
    void roomsBooked (RoomBookedInput roomBookedInput);
    void deleteRoomBooked (DeleteRoomBookedInput deleteRoomBookedInput);
}
