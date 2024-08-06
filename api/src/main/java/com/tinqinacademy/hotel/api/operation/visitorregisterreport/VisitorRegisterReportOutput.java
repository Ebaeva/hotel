package com.tinqinacademy.hotel.model.operation.visitorregisterreport;

import com.tinqinacademy.hotel.api.base.interfaces.OperationOutput;
import com.tinqinacademy.hotel.api.models.outputs.GuestOutput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VisitorRegisterReportOutput implements OperationOutput {

    private List<GuestOutput> data;


}
