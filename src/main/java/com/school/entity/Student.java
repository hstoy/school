package com.school.entity;

import javax.persistence.*;

@Entity
@Table
public class Student extends BaseEntity {
    private PersonalInformation personalInformation;
    private Teacher teacher;
    private String classRoom;
    private int grade;

    public Student() {
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Column(name = "class_room")
    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
