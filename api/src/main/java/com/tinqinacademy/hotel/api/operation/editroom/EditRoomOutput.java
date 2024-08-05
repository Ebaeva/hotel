package com.tinqinacademy.hotel.api.operation.editroom;


import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditRoomOutput implements OperationOutput {

    private String id;
}
