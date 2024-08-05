package com.tinqinacademy.hotel.api.operation.createroom;

import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class CreateRoomOutput implements OperationOutput {

    private String id;
}
