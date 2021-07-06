package com.school.service.interfaces;

import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.domain.dto.subject.SubjectDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll(Pageable pageable);

    List<SubjectDto> createSubjects(CreateSubjectList subjects);

    List<SubjectDto> updateSubjects(EditSubjectList subjects);
}
