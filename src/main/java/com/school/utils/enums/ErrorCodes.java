package com.school.utils.enums;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    // Subject
    ERR_1000(1000, "Subject name must contain only letters and length must be up to 50 letters"),
    ERR_1001(1001, "Subject with such name already exists"),
    ERR_1002(1002, "There are subjects with the same name"),
    ERR_1003(1003, "Unable to find subject Id"),
    ERR_1004(1004, "Unable to update provided subjects"),
    ERR_1005(1005, "Subject record with such Id does not exist"),

    // Employee
    ERR_1100(1100, "Employee type must be one of the following values: Teacher, Principal, Janitor, Cook"),
    ERR_1101(1101, "Employee hire date must be in the present or future"),
    ERR_1102(1102, "Employee vacation days must be between 20 and 30 days"),

    // Personal Information
    ERR_1200(1200, "First name must be between 1 and 50 letters"),
    ERR_1201(1201, "Middle name must be between 1 and 50 letters"),
    ERR_1202(1202, "Last name must be between 1 and 50 letters"),
    ERR_1203(1203, "Gender must be male or female"),
    ;

    private int errorCode;
    private String errorMessage;

    ErrorCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
