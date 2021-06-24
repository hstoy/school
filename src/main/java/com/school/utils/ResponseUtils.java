package com.school.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseUtils {
    public static ResponseEntity<Object> createErrorResponse(BindingResult result, HttpStatus httpCode, int errorCode) {
        return new ResponseEntity<>(new ApiErrorResponse() {{
            setStatus(STATUS_ERROR);
            setStatusCode(STATUS_CODE_ERROR);
            setErrorMessage(result.getFieldError().getDefaultMessage());
            setErrorCode(errorCode);
        }}, httpCode);
    }

    public static ResponseEntity<Object> createErrorResponse(String errorMessage, int errorCode, HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiErrorResponse() {{
            setStatus(STATUS_ERROR);
            setStatusCode(STATUS_CODE_ERROR);
            setErrorMessage(errorMessage);
            setErrorCode(errorCode);
        }}, httpCode);
    }

    public static ResponseEntity<Object> createSuccessResponse(HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiSuccessResponse() {{
            setStatus(STATUS_SUCCESS);
            setStatusCode(STATUS_CODE_SUCCESS);
        }}, httpCode);
    }
}
