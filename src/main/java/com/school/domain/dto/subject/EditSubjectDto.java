package com.school.domain.dto.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static com.school.constants.SubjectConstants.SUBJECT_ID_MISSING_ERROR_MESSAGE;

@Getter
@Setter
public class EditSubjectDto {

    @NotNull(message = SUBJECT_ID_MISSING_ERROR_MESSAGE)
    private Long id;

    @JsonProperty
    private boolean isActive;
}
