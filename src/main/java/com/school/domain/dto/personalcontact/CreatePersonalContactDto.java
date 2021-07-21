package com.school.domain.dto.personalcontact;

import com.school.domain.dto.BaseContactDto;
import com.school.utils.annotations.Optional;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

import static com.school.utils.constants.PersonalInformationConstants.MOBILE_VALIDATION_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.PHONE_VALIDATION_REGEX;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1204;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1206;

@Getter
@Setter
public class CreatePersonalContactDto extends BaseContactDto {

    @Pattern(regexp = MOBILE_VALIDATION_REGEX, message = PI_ERR_1204)
    private String emergencyContact;

    @Optional(message = PI_ERR_1206, regex = PHONE_VALIDATION_REGEX)
    private String phone;
}
