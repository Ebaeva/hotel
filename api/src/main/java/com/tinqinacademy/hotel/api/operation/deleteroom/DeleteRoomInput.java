package com.tinqinacademy.hotel.api.operation.deleteroom;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeleteRoomInput implements OperationInput {

    @NotBlank(message = "There is no room with this ID")
    private String id;
}
