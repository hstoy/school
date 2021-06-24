package com.school.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorResponse extends ApiSuccessResponse {
    private String errorMessage;
    private int errorCode;
}
