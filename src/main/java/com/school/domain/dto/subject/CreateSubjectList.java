package com.school.domain.dto.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class CreateSubjectList implements ListSubjectDto {
    @Valid
    @JsonProperty
    private List<CreateSubjectDto> subjects;
}
