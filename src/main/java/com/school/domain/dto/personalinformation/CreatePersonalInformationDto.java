package com.school.domain.dto.personalinformation;

import com.school.domain.dto.address.CreateAddressDto;
import com.school.domain.dto.personalcontact.CreatePersonalContactDto;
import com.school.domain.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonalInformationDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private CreatePersonalContactDto personalContact;
    private CreateAddressDto address;
}
