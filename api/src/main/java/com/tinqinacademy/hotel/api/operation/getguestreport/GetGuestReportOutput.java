package com.tinqinacademy.hotel.api.operation.getguestreport;

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
public class GetGuestReportOutput implements OperationOutput {

    private List<GuestOutput> data;
}