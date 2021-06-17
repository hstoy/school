package com.school.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Teacher extends BaseEntity {
    private Employee employee;
    private List<Student> students;
    private String subject;

    public Teacher() {
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "teacher")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
