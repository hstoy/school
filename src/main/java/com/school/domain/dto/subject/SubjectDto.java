package com.school.domain.dto.subject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDto {

    private long id;
    private String name;
    private boolean isActive;

}
