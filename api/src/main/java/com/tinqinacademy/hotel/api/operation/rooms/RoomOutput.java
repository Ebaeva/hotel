package com.tinqinacademy.hotel.api.operation.rooms;

import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoomOutput implements OperationOutput {

    private List<String> id;
}
