package com.school.domain.dto.workcontact;

import com.school.domain.dto.BaseContactDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateWorkContactDto extends BaseContactDto {

    @NotEmpty
    private String roomNumber;
}
