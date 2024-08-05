package com.tinqinacademy.hotel.rest.controllers;

import com.tinqinacademy.hotel.api.errors.Errors;
import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomInput;
import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomOutput;
import com.tinqinacademy.hotel.api.operation.deleteroom.DeleteRoomInput;
import com.tinqinacademy.hotel.api.operation.deleteroom.DeleteRoomOutput;
import com.tinqinacademy.hotel.api.operation.updateroom.UpdateRoomInput;
import com.tinqinacademy.hotel.api.operation.updateroom.UpdateRoomOutput;
import com.tinqinacademy.hotel.core.operation.CreateRoomOperationProcessor;
import com.tinqinacademy.hotel.core.operation.DeleteRoomOperationProcessor;
import com.tinqinacademy.hotel.core.operation.UpdateRoomOperationProcessor;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AdminController extends BaseController {
    private final DeleteRoomOperationProcessor deleteRoomOperationProcessor;
    private final CreateRoomOperationProcessor createRoomOperationProcessor;
    private final UpdateRoomOperationProcessor updateRoomOperationProcessor;

    public AdminController(DeleteRoomOperationProcessor deleteRoomOperationProcessor, CreateRoomOperationProcessor createRoomOperationProcessor, UpdateRoomOperationProcessor updateRoomOperationProcessor) {
        super();
        this.deleteRoomOperationProcessor = deleteRoomOperationProcessor;
        this.createRoomOperationProcessor = createRoomOperationProcessor;
        this.updateRoomOperationProcessor = updateRoomOperationProcessor;
    }
    //private final AdminService adminService;

//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
    //private final CreateRoomOperationProcessor createRoomOperationProcessor;

//    @Autowired
//    public AdminController(AdminService adminService, CreateRoomOperationProcessor createRoomOperationProcessor) {
//        this.adminService = adminService;
//        this.createRoomOperationProcessor = createRoomOperationProcessor;
//    }
//
//    @PostMapping(POST_REGISTER_VISITOR)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void registerVisitor(@RequestBody VisitorRegisterInput visitorRegisterInput) {
//        this.adminService.registerVisitor(visitorRegisterInput);
//    }
//
//    @GetMapping(GET_REPORT)
//    public ResponseEntity<VisitorRegisterReportOutput> visitorRegisterReport(VisitorRegisterReportInput visitorRegisterReportInput) {
//        VisitorRegisterReportOutput visitorRegisterReportOutput = this.adminService.registerVisitorReport(visitorRegisterReportInput);
//        return new ResponseEntity<>(visitorRegisterReportOutput, HttpStatus.OK);
//    }

//    @PostMapping(POST_CREATE_ROOM)
//    public ResponseEntity<CreateRoomOutput> createRoom(@RequestBody CreateRoomInput createRoomInput) {
//        if (this.adminService.checkIfRoomExists(createRoomInput.getRoomNo())) {
//            throw new RoomAlreadyExist(String.format("Room with number {} already exists!", createRoomInput.getRoomNo()));
//        }
//
//        CreateRoomOutput createRoomOutput = this.adminService.createRoom(createRoomInput);
//        return new ResponseEntity<>(createRoomOutput, HttpStatus.CREATED);
//    }

@PostMapping(URLMappings.POST_CREATE_ROOM)
public ResponseEntity<?> createRoom(@RequestBody CreateRoomInput input) {
    Either<Errors, CreateRoomOutput> result = createRoomOperationProcessor.process(input);
    return handleResult(result);
}


//    @PutMapping(PUT_UPDATE_ROOM_BY_ID)
//    public ResponseEntity<EditRoomOutput> editRoom(@RequestBody EditRoomInput editRoomInput, @PathVariable String roomId) {
//        editRoomInput.setId(roomId);
//       // if (this.adminService.checkIfRoomExists(editRoomInput.getRoomNo())) {
//            EditRoomOutput editRoomOutput = this.adminService.editRoom(editRoomInput);
//            return new ResponseEntity<>(editRoomOutput, HttpStatus.OK);
//       // }
//       // throw new RoomNumberNotExist(String.format("Room with number {} not exist! ", editRoomInput.getRoomNo()));
//    }

//    @PatchMapping(PATCH_EDIT_ROOM)
//    public ResponseEntity<EditRoomOutput> editRoom(@PathVariable EditRoomInput editRoomInput, @Valid @RequestBody String roomId) {
//        // editRoomInput.setId(roomId);
//        EditRoomOutput editRoomOutput = this.adminService.editRoom(editRoomInput);
//        return new ResponseEntity<>(editRoomOutput, HttpStatus.OK);
//    }
@PatchMapping(URLMappings.PATCH_EDIT_ROOM)
public ResponseEntity<?> editRoom(@RequestBody UpdateRoomInput input, @PathVariable String roomId) {
    input.setId(roomId);
    Either<Errors, UpdateRoomOutput> result = updateRoomOperationProcessor.process(input);
    return handleResult(result);
}

    @DeleteMapping(URLMappings.DELETE_ROOM)
    public ResponseEntity<?> deleteRoom(@PathVariable String roomId) {
        DeleteRoomInput input = DeleteRoomInput.builder().id(roomId).build();
        Either<Errors, DeleteRoomOutput> result = deleteRoomOperationProcessor.process(input);
        return handleResult(result);
    }
}
