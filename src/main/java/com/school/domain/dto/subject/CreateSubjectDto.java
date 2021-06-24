package com.school.domain.dto.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

import static com.school.constants.SubjectConstants.SUBJECT_NAME_ONLY_LETTERS_ERROR_MESSAGE;
import static com.school.constants.SubjectConstants.SUBJECT_NAME_VALIDATION_REGEX;

@Getter
@Setter
public class CreateSubjectDto {

    @Pattern(regexp = SUBJECT_NAME_VALIDATION_REGEX, message = SUBJECT_NAME_ONLY_LETTERS_ERROR_MESSAGE)
    private String name;

    @JsonProperty
    private boolean isActive;

}
