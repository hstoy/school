package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Student extends BaseEntity {

    @Getter
    @Setter
    @Column(length = 2)
    private int grade;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Parent> parents;

    @Getter
    @Setter
    @OneToMany(mappedBy = "student")
    private Set<Grades> grades;
}
