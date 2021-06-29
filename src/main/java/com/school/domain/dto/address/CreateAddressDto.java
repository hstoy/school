package com.school.domain.dto.address;

import com.school.domain.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressDto {

    private String addressType;
    private String city;
    private String area;
    private String street;
    private String block;
    private long personalInformationId;
}
