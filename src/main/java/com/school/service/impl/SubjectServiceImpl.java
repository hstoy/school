package com.school.service.impl;

import com.school.domain.dto.subject.CreateSubjectDto;
import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.domain.dto.subject.ListSubjectDto;
import com.school.domain.dto.subject.SubjectDto;
import com.school.domain.entity.Subject;
import com.school.repository.SubjectRepository;
import com.school.service.interfaces.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.school.constants.SubjectConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static com.school.constants.SubjectConstants.SUBJECT_NAME_EXISTS_ERROR_MESSAGE;
import static com.school.constants.SubjectConstants.UNABLE_TO_UPDATE_SUBJECT_ERROR_MESSAGE;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, ModelMapper modelMapper) {
        this.subjectRepository = subjectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, SubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createSubjects(CreateSubjectList subjects) {
        if (hasDuplicates(subjects)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }

        try {
            subjectRepository.saveAll(mapSubjectDtoToSubject(subjects));
        } catch (Exception e) {
            throw new IllegalArgumentException(SUBJECT_NAME_EXISTS_ERROR_MESSAGE);
        }
    }

    @Override
    public void updateSubjects(EditSubjectList subjects) throws SQLException {
        for (Subject subject : mapSubjectDtoToSubject(subjects)) {
            Optional<Subject> recordToUpdate = subjectRepository.findById(subject.getId());

            if (recordToUpdate.isPresent()) {
                recordToUpdate.get().setActive(subject.isActive());
                subjectRepository.save(recordToUpdate.get());
            }
        }
    }

    private List<Subject> mapSubjectDtoToSubject(ListSubjectDto subjects) {
        return subjects.getSubjects()
                .stream()
                .map(s -> modelMapper.map(s, Subject.class))
                .collect(Collectors.toList());
    }

    private boolean hasDuplicates(CreateSubjectList subjects) {
        return new HashSet<>(subjects.getSubjects()
                .stream()
                .map(CreateSubjectDto::getName)
                .collect(Collectors.toSet()))
                .size() < subjects.getSubjects().size();
    }
}
