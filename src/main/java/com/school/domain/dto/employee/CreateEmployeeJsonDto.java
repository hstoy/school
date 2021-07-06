package com.school.domain.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class CreateEmployeeJsonDto {

    @Valid
    @JsonProperty(value = "employee")
    private CreateEmployeeDto createEmployeeDto;
}
