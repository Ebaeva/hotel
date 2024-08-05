package com.tinqinacademy.hotel.api.operation.roombooked;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RoomBookedInput implements OperationInput {

    private String roomId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String firstName;

    private String lastName;

    private String phoneNo;
}
