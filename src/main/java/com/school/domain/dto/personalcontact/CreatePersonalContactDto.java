package com.school.domain.dto.personalcontact;

import com.school.domain.dto.BaseContactDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonalContactDto extends BaseContactDto {
    
    private String emergencyContact;
    private String phone;
}
