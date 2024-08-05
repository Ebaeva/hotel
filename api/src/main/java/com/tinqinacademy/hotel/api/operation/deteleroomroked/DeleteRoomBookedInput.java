package com.tinqinacademy.hotel.api.operation.deteleroomroked;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeleteRoomBookedInput implements OperationInput {

    private String id;
}
