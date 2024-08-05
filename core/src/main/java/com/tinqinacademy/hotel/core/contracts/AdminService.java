package com.tinqinacademy.hotel.core.contracts;

import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomInput;
import com.tinqinacademy.hotel.api.operation.createroom.CreateRoomOutput;
import com.tinqinacademy.hotel.api.operation.deleteroom.DeleteRoomInput;
import com.tinqinacademy.hotel.api.operation.editroom.EditRoomInput;
import com.tinqinacademy.hotel.api.operation.editroom.EditRoomOutput;

public interface AdminService {
    //void registerVisitor(VisitorRegisterInput visitorRegisterInput);

   // VisitorRegisterReportOutput registerVisitorReport(VisitorRegisterReportInput visitorRegisterReportInput);

    //CreateRoomOutput createRoom(CreateRoomInput createRoomInput);

    EditRoomOutput editRoom(EditRoomInput editRoomInput);

    CreateRoomOutput editRoom(CreateRoomInput createRoomInput);

    void deleteRoom(DeleteRoomInput deleteRoomInput);

    //VisitorRegisterReportOutput visitorRegisterReportOutput(VisitorRegisterReportInput input);

    Boolean checkIfRoomExists(String roomNumber);
}
