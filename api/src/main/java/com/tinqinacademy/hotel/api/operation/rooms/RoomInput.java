package com.tinqinacademy.hotel.api.operation.rooms;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import com.tinqinacademy.hotel.api.enums.BathroomType;
import com.tinqinacademy.hotel.api.enums.Bed;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoomInput implements OperationInput {

    private LocalDate startDate;

    private LocalDate endDate;

    private int bedCount;

    private Bed bedSize;

    private BathroomType bathroomType;
}
