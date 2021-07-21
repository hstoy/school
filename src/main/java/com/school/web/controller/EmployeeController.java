package com.school.web.controller;

import com.school.domain.dto.employee.CreateEmployeeJsonDto;
import com.school.service.interfaces.EmployeeService;
import com.school.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity createEmployee(@Valid @RequestBody CreateEmployeeJsonDto model, BindingResult result) {
        if (result.hasErrors()) {
            return ApiResponse.createErrorResponse(result, HttpStatus.BAD_REQUEST);
        }

        return ApiResponse.createSuccessResponse(employeeService.createEmployee(model), HttpStatus.CREATED);
    }
}
