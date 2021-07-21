package com.school.domain.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.config.mapper.CustomMapping;
import com.school.domain.dto.personalinformation.CreatePersonalInformationDto;
import com.school.domain.dto.workcontact.CreateWorkContactDto;
import com.school.domain.entity.Employee;
import com.school.domain.enums.EmployeeType;
import com.school.utils.annotations.EnumValidator;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1100;
import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1101;
import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1102;
import static com.school.utils.constants.EmployeeConstants.EMPLOYEE_ERR_1103;

@Getter
@Setter
public class CreateEmployeeDto implements CustomMapping {

    @EnumValidator(message = EMPLOYEE_ERR_1100, enumType = EmployeeType.class)
    private String employeeType;

    @Valid
    @JsonProperty
    private CreatePersonalInformationDto personalInformation;

    @Valid
    @JsonProperty
    private CreateWorkContactDto workContact;

    @NotEmpty(message = EMPLOYEE_ERR_1101)
    private String hireDate;

    @Max(value = 40, message = EMPLOYEE_ERR_1102)
    @Min(value = 20, message = EMPLOYEE_ERR_1102)
    private int totalVacationDays;

    @Override
    public void configureMappings(ModelMapper mapper) {
        mapper.createTypeMap(CreateEmployeeDto.class, Employee.class)
                .addMapping(CreateEmployeeDto::getHireDate,
                        (d, v) -> {
                            try {
                                d.setHireDate(new SimpleDateFormat("dd/MM/yyyy").parse(v.toString()));
                            } catch (ParseException e) {
                                throw new IllegalArgumentException(EMPLOYEE_ERR_1103);
                            }
                        });
    }
}
