package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Subject extends BaseEntity {

    @Getter
    @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Getter
    @Setter
    @Column(name = "is_active")
    private boolean isActive;

    @Getter
    @Setter
    @OneToOne(mappedBy = "subject")
    private Teacher teacher;

    @Getter
    @Setter
    @OneToOne(mappedBy = "subject")
    private Grades grades;
}
