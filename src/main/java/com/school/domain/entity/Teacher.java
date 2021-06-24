package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Teacher extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
