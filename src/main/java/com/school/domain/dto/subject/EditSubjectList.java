package com.school.domain.dto.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class EditSubjectList implements ListSubjectDto {

    @Valid
    @JsonProperty
    private List<EditSubjectDto> subjects;
}
