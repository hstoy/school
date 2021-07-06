package com.school.domain.dto.personalinformation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.domain.dto.address.CreateAddressDto;
import com.school.domain.dto.personalcontact.CreatePersonalContactDto;
import com.school.domain.enums.Gender;
import com.school.utils.annotations.EnumValidator;
import com.school.utils.annotations.Optional;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1200;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1201;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1202;
import static com.school.utils.constants.PersonalInformationConstants.PI_ERR_1203;

@Getter
@Setter
public class CreatePersonalInformationDto {

    @Min(value = 1, message = PI_ERR_1200)
    @Max(value = 50, message = PI_ERR_1200)
    private String firstName;

    @Optional(message = PI_ERR_1201)
    private String middleName;

    @Min(value = 1, message = PI_ERR_1202)
    @Max(value = 50, message = PI_ERR_1202)
    private String lastName;

    @EnumValidator(message = PI_ERR_1203, enumType = Gender.class)
    private String gender;

    @Valid
    @JsonProperty
    private CreatePersonalContactDto personalContact;

    @Valid
    @JsonProperty
    private CreateAddressDto address;
}
