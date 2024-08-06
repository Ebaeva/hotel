package com.tinqinacademy.hotel.api.operation.createroom;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateRoomInput implements OperationInput {

    private List<String> beds;

    private String bathroomType;

    private Integer floor;

    @Size(min = 0, max = 12, message = "invalid string")
    private String roomN;

    @Digits(integer = 4, fraction = 2, message = "invalid number")
    private BigDecimal price;
}
