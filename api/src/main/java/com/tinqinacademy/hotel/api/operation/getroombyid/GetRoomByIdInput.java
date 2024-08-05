package com.tinqinacademy.hotel.api.operation.getroombyid;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetRoomByIdInput implements OperationInput {
    private String id;
}
