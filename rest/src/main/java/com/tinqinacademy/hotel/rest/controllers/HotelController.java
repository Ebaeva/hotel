package com.tinqinacademy.hotel.rest.controllers;

import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedInput;
import com.tinqinacademy.hotel.api.operation.roombooked.RoomBookedInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomOutput;
import com.tinqinacademy.hotel.api.operation.getroombyid.GetRoomByIdOutput;
import com.tinqinacademy.hotel.core.contracts.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tinqinacademy.hotel.rest.controllers.URLMappings.*;

@RestController
public class HotelController extends BaseController  {
    private final HotelService roomsService;

    public HotelController(HotelService roomsService) {
        this.roomsService = roomsService;
    }


    @GetMapping(GET_ROOM)
    public ResponseEntity<List<String>> checkRoomAvailability(RoomInput roomsInput) {
        RoomOutput roomsOutput = this.roomsService.checkRoomAvailability(roomsInput);
        return new ResponseEntity<>(roomsOutput.getId(), HttpStatus.OK);
    }

    @GetMapping(GET_ROOM_BY_ID)
    public ResponseEntity<GetRoomByIdOutput> getRoomInfo(@PathVariable(name = "roomId") String id) {
        GetRoomByIdOutput roomsIdOutput = this.roomsService.getRoomInfoById(id);
        return new ResponseEntity<>(roomsIdOutput, HttpStatus.OK);
    }

    @PostMapping(POST_BOOK_ROOMS_BY_ID)
    @ResponseStatus(HttpStatus.CREATED)
    public void bookARoom(@RequestBody RoomBookedInput roomBookedInput) {

        this.roomsService.roomsBooked(roomBookedInput);
    }

    @DeleteMapping(DELETE_BOOKING_BY_ID)
    public void deleteABookedRoom(@RequestBody DeleteRoomBookedInput deleteRoomBookedInput) {
        this.roomsService.deleteRoomBooked(deleteRoomBookedInput);
    }
}
