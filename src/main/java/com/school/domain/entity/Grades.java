package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Grades extends BaseEntity {

    @Column(scale = 3, precision = 2)
    private Double grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
