package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Teacher extends BaseEntity {

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
