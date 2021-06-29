package com.school.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseContactDto {

    private String email;
    private String mobile;
}
