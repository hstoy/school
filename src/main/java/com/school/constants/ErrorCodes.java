package com.school.constants;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    ERR_1000(1000, "Subject name must contain only letters and length must be up to 50 letters"),
    ERR_1001(1001, "Subject with such name already exists"),
    ERR_1002(1002, "There are subjects with the same name"),
    ERR_1003(1003, "Unable to find subject Id"),
    ERR_1004(1004, "Unable to update provided subjects"),
    ERR_1005(1005, "Subject record with such Id does not exist"),
    ;

    private int errorCode;
    private String errorMessage;

    ErrorCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
