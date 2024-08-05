package com.tinqinacademy.hotel.api.operation.getroombyid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetRoomByIdOutput implements OperationOutput {

    private String id;

    private BigDecimal price;

    private Integer floor;

    private List<String> beds;

    private String bathroomType;

    private String number;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<LocalDate> datesOccupied;

}
