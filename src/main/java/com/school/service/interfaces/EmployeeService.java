package com.school.service.interfaces;

import com.school.domain.dto.employee.CreateEmployeeJsonDto;

public interface EmployeeService {

    long createEmployee(CreateEmployeeJsonDto employee);
}
