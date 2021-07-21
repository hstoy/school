package com.school.domain.dto.address;

import com.school.domain.enums.AddressType;
import com.school.utils.annotations.EnumValidator;
import com.school.utils.annotations.Optional;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import static com.school.utils.constants.AddressConstant.ADDRESS_ERR_1300;
import static com.school.utils.constants.AddressConstant.ADDRESS_ERR_1301;
import static com.school.utils.constants.AddressConstant.ADDRESS_ERR_1302;
import static com.school.utils.constants.AddressConstant.ADDRESS_ERR_1303;
import static com.school.utils.constants.AddressConstant.ADDRESS_ERR_1304;
import static com.school.utils.constants.PersonalInformationConstants.NAME_VALIDATION_REGEX;

@Getter
@Setter
public class CreateAddressDto {

    @EnumValidator(enumType = AddressType.class, message = ADDRESS_ERR_1300)
    private String addressType;

    @NotEmpty(message = ADDRESS_ERR_1301)
    private String city;

    @Optional(message = ADDRESS_ERR_1302, regex = NAME_VALIDATION_REGEX)
    private String area;

    @NotEmpty(message = ADDRESS_ERR_1303)
    private String street;

    @NotEmpty(message = ADDRESS_ERR_1304)
    private String block;
}
