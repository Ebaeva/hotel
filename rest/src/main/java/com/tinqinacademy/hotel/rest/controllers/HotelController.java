package com.tinqinacademy.hotel.rest.controllers;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedInput;
import com.tinqinacademy.hotel.api.operation.deteleroomroked.DeleteRoomBookedOutput;
import com.tinqinacademy.hotel.api.operation.getroombyid.GetRoomByIdInput;
import com.tinqinacademy.hotel.api.operation.getroombyid.GetRoomByIdOutput;
import com.tinqinacademy.hotel.api.operation.reserveroombyid.ReserveRoomByIdInput;
import com.tinqinacademy.hotel.api.operation.reserveroombyid.ReserveRoomByIdOutput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomInput;
import com.tinqinacademy.hotel.api.operation.rooms.RoomOutput;
import com.tinqinacademy.hotel.core.contracts.HotelService;
import com.tinqinacademy.hotel.core.operation.DeleteBookingOperationProcessor;
import com.tinqinacademy.hotel.core.operation.GetRoomByIdOperationProcessor;
import com.tinqinacademy.hotel.core.operation.ReserveRoomOperationProcessor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.tinqinacademy.hotel.rest.controllers.URLMappings.GET_ROOM;
import static com.tinqinacademy.hotel.rest.controllers.URLMappings.POST_BOOK_ROOMS_BY_ID;

@RestController
public class HotelController extends BaseController  {
    private final HotelService roomsService;
    private final ReserveRoomOperationProcessor reserveRoomOperationProcessor;
    private final GetRoomByIdOperationProcessor getRoomByIdOperationProcessor;
    private final DeleteBookingOperationProcessor deleteBookingOperationProcessor;

    public HotelController(HotelService roomsService, ReserveRoomOperationProcessor reserveRoomOperationProcessor, GetRoomByIdOperationProcessor getRoomByIdOperationProcessor, DeleteBookingOperationProcessor deleteBookingOperationProcessor) {
        this.roomsService = roomsService;
        this.reserveRoomOperationProcessor = reserveRoomOperationProcessor;
        this.getRoomByIdOperationProcessor = getRoomByIdOperationProcessor;
        this.deleteBookingOperationProcessor = deleteBookingOperationProcessor;
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room Booked successfully"),
            @ApiResponse(responseCode = "404", description = "Room not found")
    })
    @Operation(
            summary = "Books a room",
            description = "Books a room"
    )
    @GetMapping(GET_ROOM)
    public ResponseEntity<List<String>> checkRoomAvailability(RoomInput roomsInput) {
        RoomOutput roomsOutput = this.roomsService.checkRoomAvailability(roomsInput);
        return new ResponseEntity<>(roomsOutput.getId(), HttpStatus.OK);
    }


//    @GetMapping(GET_ROOM_BY_ID)
//    public ResponseEntity<GetRoomByIdOutput> getRoomInfo(@PathVariable(name = "roomId") String id) {
//        GetRoomByIdOutput roomsIdOutput = this.roomsService.getRoomInfoById(id);
//        return new ResponseEntity<>(roomsIdOutput, HttpStatus.OK);
//    }
@GetMapping(URLMappings.GET_ROOM_BY_ID)
public ResponseEntity<?> getRoomById(@PathVariable UUID roomId) {
    GetRoomByIdInput roomsServiceRoomById = GetRoomByIdInput.builder().id(String.valueOf(roomId)).build();

    Either<Errors, GetRoomByIdOutput> result = getRoomByIdOperationProcessor.process(roomsServiceRoomById);

    return handleResult(result);
}

//    @PostMapping(POST_BOOK_ROOMS_BY_ID)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void bookARoom(@RequestBody RoomBookedInput roomBookedInput) {
//
//        this.roomsService.roomsBooked(roomBookedInput);
//    }
    @PostMapping(POST_BOOK_ROOMS_BY_ID)
    public ResponseEntity<?> bookRoom(@RequestBody ReserveRoomByIdInput input) {
        Either<Errors, ReserveRoomByIdOutput> result = reserveRoomOperationProcessor.process(input);
        return handleResult(result);
    }

//    @DeleteMapping(DELETE_BOOKING_BY_ID)
//    public void deleteABookedRoom(@RequestBody DeleteRoomBookedInput deleteRoomBookedInput) {
//        this.roomsService.deleteRoomBooked(deleteRoomBookedInput);
//    }
@DeleteMapping(URLMappings.DELETE_BOOKING_BY_ID)
public ResponseEntity<?> deleteBookingById(@PathVariable String bookingId) {
    DeleteRoomBookedInput input = DeleteRoomBookedInput
            .builder()
            .id(bookingId)
            .build();
    Either<Errors, DeleteRoomBookedOutput> result = deleteBookingOperationProcessor.process(input);
    return handleResult(result);

}
}
