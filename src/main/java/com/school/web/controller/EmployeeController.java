package com.school.web.controller;

import com.school.domain.dto.employee.CreateEmployeeJsonDto;
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

    @PostMapping
    public ResponseEntity createSubjects(@Valid @RequestBody CreateEmployeeJsonDto model, BindingResult result) {
        return null;
    }
}
