package com.school.domain.dto.subject;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

import static com.school.utils.constants.SubjectConstants.SUBJECT_ERR_1000;
import static com.school.utils.constants.SubjectConstants.SUBJECT_NAME_VALIDATION_REGEX;

@Getter
@Setter
public class CreateSubjectDto {

    @Pattern(regexp = SUBJECT_NAME_VALIDATION_REGEX, message = SUBJECT_ERR_1000)
    private String name;
    private boolean isActive;

}
