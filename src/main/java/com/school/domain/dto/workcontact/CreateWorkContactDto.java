package com.school.domain.dto.workcontact;

import com.school.domain.dto.BaseContactDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWorkContactDto extends BaseContactDto {

    private String roomNumber;
}
