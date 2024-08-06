package com.tinqinacademy.hotel.api.operation.visitorregister;

import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import com.tinqinacademy.hotel.api.models.inputs.GuestInput;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class VisitorRegisterOutput implements OperationOutput {

    List<GuestInput> guests;
}
