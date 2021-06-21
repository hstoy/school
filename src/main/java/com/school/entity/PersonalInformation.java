package com.school.entity;

import com.school.entity.base.BaseEntity;
import com.school.entity.enums.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "personal_information")
public class PersonalInformation extends BaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Date dateOfBirth;

    private Employee employee;
    private Set<Address> address;
    private PersonalContact personalContact;
    private Student student;
    private Parent parent;

    public PersonalInformation() {
    }

    @Column(name = "first_name", length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name", length = 50)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "last_name", length = 50, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE')")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(mappedBy = "personalInformation")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy = "personalInformation")
    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    public PersonalContact getPersonalContact() {
        return personalContact;
    }

    public void setPersonalContact(PersonalContact personalContact) {
        this.personalContact = personalContact;
    }

    @OneToOne(mappedBy = "personalInformation")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne(mappedBy = "personalInformation")
    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
