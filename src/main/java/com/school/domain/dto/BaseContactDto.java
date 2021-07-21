package com.school.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import static com.school.utils.constants.PersonalInformationConstants.MOBILE_VALIDATION_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1204;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1205;

@Getter
@Setter
public abstract class BaseContactDto {

    @Email(message = PI_ERR_1204)
    private String email;

    @Pattern(regexp = MOBILE_VALIDATION_REGEX, message = PI_ERR_1205)
    private String mobile;
}
