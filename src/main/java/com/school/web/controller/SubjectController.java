package com.school.web.controller;

import com.school.domain.dto.subject.CreateSubjectList;
import com.school.domain.dto.subject.EditSubjectList;
import com.school.service.interfaces.SubjectService;
import com.school.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import java.util.Collections;

@RestController
@RequestMapping(value = "/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity getSubjects(Pageable pageable) {
        return ApiResponse.createSuccessResponse(Collections.singletonList(subjectService.findAll(pageable)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createSubjects(@Valid @RequestBody CreateSubjectList model, BindingResult result) { ;
        return ApiResponse.createSuccessResponse(Collections.singletonList(subjectService.createSubjects(model)), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity editSubjects(@Valid @RequestBody EditSubjectList model, BindingResult result) {
        return ApiResponse.createSuccessResponse(Collections.singletonList(subjectService.updateSubjects(model)), HttpStatus.OK);
    }
}
