package com.school.domain.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.domain.dto.personalinformation.CreatePersonalInformationDto;
import com.school.domain.dto.workcontact.CreateWorkContactDto;
import com.school.domain.enums.EmployeeType;
import com.school.utils.annotations.EnumValidator;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1100;
import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1101;
import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1102;

@Getter
@Setter
public class CreateEmployeeDto {

    @EnumValidator(message = EMPLOYEE_ERR_1100, enumType = EmployeeType.class)
    private String employeeType;

    @Valid
    @JsonProperty
    private CreatePersonalInformationDto personalInformation;

    @Valid
    @JsonProperty
    private CreateWorkContactDto workContact;

    @FutureOrPresent(message = EMPLOYEE_ERR_1101)
    private LocalDate hireDate;

    @Max(value = 30, message = EMPLOYEE_ERR_1102)
    @Min(value = 20, message = EMPLOYEE_ERR_1102)
    private int totalVacationDays;

}
