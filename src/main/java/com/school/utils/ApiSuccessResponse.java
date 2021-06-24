package com.school.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiSuccessResponse {
    public static String STATUS_ERROR = "error";
    public static String STATUS_SUCCESS = "success";
    public static int STATUS_CODE_ERROR = 0;
    public static int STATUS_CODE_SUCCESS = 1;

    private String status;
    private int statusCode;
}
