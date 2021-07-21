package com.school.service.impl;

import com.school.domain.dto.address.CreateAddressDto;
import com.school.domain.dto.employee.CreateEmployeeDto;
import com.school.domain.dto.employee.CreateEmployeeJsonDto;
import com.school.domain.dto.personalinformation.CreatePersonalInformationDto;
import com.school.domain.entity.Employee;
import com.school.repository.EmployeeRepository;
import com.school.service.interfaces.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.school.utils.constants.PersonalInformationConstants.ENTITY_NAME_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.MOBILE_NUMBER_LENGTH_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.PERSONAL_CONTACT_ENTITY;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1207;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1208;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1209;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1210;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public long createEmployee(CreateEmployeeJsonDto employee) {
        try {
            Employee employeeToCreate = modelMapper.map(setEnumsToUpperCase(employee), Employee.class);
            return employeeRepository.save(employeeToCreate).getId();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(getErrorCodeByExMessage(e.getMostSpecificCause().getMessage()));
        }
    }

    private CreateEmployeeDto setEnumsToUpperCase(CreateEmployeeJsonDto employee) {
        CreateEmployeeDto employeeDto = employee.getCreateEmployeeDto();
        employeeDto.setEmployeeType(employeeDto.getEmployeeType().toUpperCase());

        CreatePersonalInformationDto personalInformation = employeeDto.getPersonalInformation();
        personalInformation.setGender(personalInformation.getGender().toUpperCase());

        Set<CreateAddressDto> address = personalInformation.getAddress();
        address.forEach(a -> a.setAddressType(a.getAddressType().toUpperCase()));

        return employeeDto;
    }

    private String getErrorCodeByExMessage(String exMessage) {
        String entity = getValue(exMessage, ENTITY_NAME_REGEX);

        if (getValue(exMessage, MOBILE_NUMBER_LENGTH_REGEX).length() == 0) {
            return getErrorCode(entity, new String[]{PI_ERR_1207, PI_ERR_1208});
        }

        return getErrorCode(entity, new String[]{PI_ERR_1209, PI_ERR_1210});
    }

    private String getValue(String exMessage, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(exMessage);
        return matcher.find() ? exMessage.substring(matcher.start(), matcher.end()) : "";
    }

    private String getErrorCode(String entity, String[] errorCodes) {
        return entity.equalsIgnoreCase(PERSONAL_CONTACT_ENTITY) ? errorCodes[0] : errorCodes[1];
    }
}
