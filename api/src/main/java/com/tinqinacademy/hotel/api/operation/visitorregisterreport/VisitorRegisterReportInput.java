package com.tinqinacademy.hotel.model.operation.visitorregisterreport;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VisitorRegisterReportInput implements OperationInput {

    private LocalDate startDate;

    @Future(message = "Date need to be greater than current date")
    private LocalDate endDate;

    @NotEmpty
    private String firstName;

    private String lastName;

    private String cardIssueDate;

    private String cardValidityDate;

    private String cardIdN;

    private String cardIssueAuthority;

    private String birthdate;

    private String phoneN;

    private String roomN;

    private List<String> data;


}
