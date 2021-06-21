package com.school.model;

import com.school.model.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table
public class Grades extends BaseEntity {
    private double grade;
    private Student student;
    private Subject subject;

    public Grades() {
    }

    @Column(scale = 3, precision = 2)
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @ManyToOne
    @JoinColumn(name = "student")
    public Student getStudents() {
        return student;
    }

    public void setStudents(Student student) {
        this.student = student;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
