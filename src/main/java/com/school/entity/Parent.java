package com.school.entity;

import com.school.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Parent extends BaseEntity {
    private PersonalInformation personalInformation;
    private Set<Student> students;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_information_id")
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @ManyToMany(mappedBy = "parents")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
