package com.tinqinacademy.hotel.api.operation.editroom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditRoomInput implements OperationInput {

    @JsonIgnore
    private UUID id;

    private List<String> bedSizes;

    @Size(max = 7, message = "invalid bathroom type")
    private String bathroomType;

    private Integer floor;

    private String roomN;

    @Digits(integer = 4, fraction = 2, message = "invalid price")
    private BigDecimal price;
}
