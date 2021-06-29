package com.school.domain.dto.employee;

import com.school.domain.dto.personalinformation.CreatePersonalInformationDto;
import com.school.domain.dto.workcontact.CreateWorkContactDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class CreateEmployeeDto {

    @Pattern(regexp = "[]]")
    private String employeeType;
    private CreatePersonalInformationDto personalInformation;
    private CreateWorkContactDto workContact;
    private LocalDate hireDate;
    private int totalVacationDays;

}
