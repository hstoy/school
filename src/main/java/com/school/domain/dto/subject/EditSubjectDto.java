package com.school.domain.dto.subject;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static com.school.constants.SubjectConstants.SUBJECT_ERR_1003;

@Getter
@Setter
public class EditSubjectDto {

    @NotNull(message = SUBJECT_ERR_1003)
    private Long id;

    private boolean isActive;
}
