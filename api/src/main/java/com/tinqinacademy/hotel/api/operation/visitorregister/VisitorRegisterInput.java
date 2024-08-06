package com.tinqinacademy.hotel.api.operation.visitorregister;

import com.tinqinacademy.hotel.api.base.interfaces.OperationInput;
import com.tinqinacademy.hotel.api.models.inputs.GuestInput;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VisitorRegisterInput implements OperationInput {

    List<GuestInput> guests;

//    private LocalDate startDate;
//
//    private LocalDate endDate;
//    @NotNull(message = "First name can not be empty!")
//    @Size(min = 3, max = 25)
//    private String firstName;
//
//    private String lastName;
//
//    private String phoneNo;
//
//    private String idCardNo;
//
//    private LocalDate idCardValidity;
//
//    private String idCardIssueAuthority;
//
//    private LocalDate idCardIssueDate;
//
//    private String roomNo;
//
//    private LocalDate birthDate;

}
