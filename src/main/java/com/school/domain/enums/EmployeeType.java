package com.school.domain.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EmployeeType {
    @JsonProperty
    TEACHER, PRINCIPAL, JANITOR, COOK
}
