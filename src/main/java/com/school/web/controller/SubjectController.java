package com.school.web.controller;

import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.domain.dto.subject.SubjectDto;
import com.school.service.interfaces.SubjectService;
import com.school.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

import static com.school.constants.SubjectConstants.DUPLICATE_NAME_ERROR_CODE;
import static com.school.constants.SubjectConstants.SUBJECT_ID_MISSING_ERROR_CODE;
import static com.school.constants.SubjectConstants.SUBJECT_NAME_ONLY_LETTERS_ERROR_CODE;
import static com.school.constants.SubjectConstants.UNABLE_TO_UPDATE_SUBJECT_ERROR_CODE;

@RestController
@RequestMapping(value = "/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectDto> getSubjects() {
        return subjectService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createSubjects(@Valid @RequestBody CreateSubjectList model, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseUtils.createErrorResponse(result, HttpStatus.BAD_REQUEST, SUBJECT_NAME_ONLY_LETTERS_ERROR_CODE);
        }

        try {
            subjectService.createSubjects(model);
        } catch (IllegalArgumentException e) {
            return ResponseUtils.createErrorResponse(e.getMessage(), DUPLICATE_NAME_ERROR_CODE, HttpStatus.BAD_REQUEST);
        }

        return ResponseUtils.createSuccessResponse(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity<Object> editSubjects(@Valid @RequestBody EditSubjectList model, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseUtils.createErrorResponse(result, HttpStatus.BAD_REQUEST, SUBJECT_ID_MISSING_ERROR_CODE);
        }

        try {
            subjectService.updateSubjects(model);
        } catch (SQLException e) {
            return ResponseUtils.createErrorResponse(e.getMessage(), UNABLE_TO_UPDATE_SUBJECT_ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseUtils.createSuccessResponse(HttpStatus.NO_CONTENT);
    }
}
