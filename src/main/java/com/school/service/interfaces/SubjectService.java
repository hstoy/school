package com.school.service.interfaces;

import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.domain.dto.subject.SubjectDto;

import java.sql.SQLException;
import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAll();

    void createSubjects(CreateSubjectList subjects);

    void updateSubjects(EditSubjectList subjects) throws SQLException;
}
