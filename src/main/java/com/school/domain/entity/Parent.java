package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Parent extends BaseEntity {

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "parents")
    private Set<Student> students;
}
