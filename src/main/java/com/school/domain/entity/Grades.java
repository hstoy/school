package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Grades extends BaseEntity {

    @Getter
    @Setter
    @Column(scale = 3, precision = 2)
    private double grade;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
