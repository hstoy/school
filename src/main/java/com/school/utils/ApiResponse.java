package com.school.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.utils.enums.ErrorCodes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ApiResponse {

    public static String STATUS_SUCCESS = "success";
    public static int STATUS_CODE_SUCCESS = 1;
    public static String STATUS_ERROR = "error";
    public static int STATUS_CODE_ERROR = -1;

    private String status;
    private int statusCode;
    private String errorMessage;
    private int errorCode;
    private List<Object> result;
    private long recordId;

    public static ResponseEntity createErrorResponse(BindingResult result, HttpStatus httpCode) {
        String error = result.getFieldError().getDefaultMessage();

        return new ResponseEntity<>(new ApiResponse() {{
            setStatus(STATUS_ERROR);
            setStatusCode(STATUS_CODE_ERROR);
            setErrorMessage(ErrorCodes.valueOf(error).getErrorMessage());
            setErrorCode((ErrorCodes.valueOf(error).getErrorCode()));
        }}, httpCode);
    }

    public static ResponseEntity createErrorResponse(String error, HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiResponse() {{
            setStatus(STATUS_ERROR);
            setStatusCode(STATUS_CODE_ERROR);
            setErrorMessage(ErrorCodes.valueOf(error).getErrorMessage());
            setErrorCode(ErrorCodes.valueOf(error).getErrorCode());
        }}, httpCode);
    }

    public static ResponseEntity createSuccessResponse(List<Object> result, HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiResponse() {{
            setStatus(STATUS_SUCCESS);
            setStatusCode(STATUS_CODE_SUCCESS);
            setResult(result);
        }}, httpCode);
    }

    public static ResponseEntity createSuccessResponse(long id, HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiResponse() {{
            setStatus(STATUS_SUCCESS);
            setStatusCode(STATUS_CODE_SUCCESS);
            setRecordId(id);
        }}, httpCode);
    }

    public static ResponseEntity createSuccessResponse(HttpStatus httpCode) {
        return new ResponseEntity<>(new ApiResponse() {{
            setStatus(STATUS_SUCCESS);
            setStatusCode(STATUS_CODE_SUCCESS);
        }}, httpCode);
    }
}
