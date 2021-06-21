package com.school.model;

import com.school.model.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Teacher extends BaseEntity {
    private Employee employee;
    private Set<Student> students;
    private Subject subject;

    public Teacher() {
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany(mappedBy = "teachers")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToOne
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
