package com.tinqinacademy.hotel.api.operation.reserveroombyid;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReserveRoomByIdInput implements OperationInput {

    private LocalDate startDate;
    private LocalDate endDate;

    private String roomId;

    private String firstName;
    private String lastName;
    private String phone;
}
