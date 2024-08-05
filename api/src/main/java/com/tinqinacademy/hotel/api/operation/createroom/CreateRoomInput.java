package com.tinqinacademy.hotel.api.operation.createroom;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import com.tinqinacademy.hotel.api.enums.BathroomType;
import jakarta.validation.constraints.Digits;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateRoomInput  implements OperationInput {

    private Integer bedCount;

    private List<String> beds;

    private BathroomType bathroomType;

    private Integer floor;

    private String roomNo;

    @Digits(integer = 4, fraction = 2, message = "invalid price")
    private BigDecimal price;
}
