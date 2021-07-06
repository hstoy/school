package com.school.service.impl;

import com.school.constants.ErrorCodes;
import com.school.domain.dto.subject.CreateSubjectDto;
import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.domain.dto.subject.ListSubjectDto;
import com.school.domain.dto.subject.SubjectDto;
import com.school.domain.entity.Subject;
import com.school.exceptions.RecordNotFoundException;
import com.school.repository.SubjectRepository;
import com.school.service.interfaces.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<SubjectDto> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable)
                .stream()
                .map(r -> modelMapper.map(r, SubjectDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDto> createSubjects(CreateSubjectList subjects) {
        if (hasDuplicates(subjects)) {
            throw new IllegalArgumentException(ErrorCodes.ERR_1002.name());
        }

        try {
            return subjectRepository
                    .saveAll(mapSubjectDtoToSubject(subjects))
                    .stream()
                    .map(r -> modelMapper.map(r, SubjectDto.class))
                    .collect(Collectors.toList());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(ErrorCodes.ERR_1001.name());
        }
    }

    @Override
    public List<SubjectDto> updateSubjects(EditSubjectList subjects) {
        List<SubjectDto> subjectDtos = new ArrayList<>();

        for (Subject subject : mapSubjectDtoToSubject(subjects)) {
            Optional<Subject> recordToUpdate = subjectRepository.findById(subject.getId());

            if (!recordToUpdate.isPresent()) {
                throw new RecordNotFoundException(ErrorCodes.ERR_1005.name());
            }

            recordToUpdate.get().setActive(subject.isActive());
            subjectRepository.save(recordToUpdate.get());

            subjectDtos.add(new SubjectDto() {{
                setId(recordToUpdate.get().getId());
            }});
        }

        return subjectDtos;
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
