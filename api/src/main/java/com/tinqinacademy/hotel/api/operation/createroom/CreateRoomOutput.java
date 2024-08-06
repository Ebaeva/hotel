package com.tinqinacademy.hotel.api.operation.createroom;

import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class CreateRoomOutput implements OperationOutput {

    private UUID id;

    private String roomNumber;

    private Integer roomFloor;

    private BigDecimal roomPrice;

    private String roomBathroomType;

    private List<String> bedSizes;
}
