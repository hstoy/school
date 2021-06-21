package com.school.model;

import com.school.model.base.BaseEntity;
import com.school.model.enums.EmployeeType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Employee extends BaseEntity {
    private EmployeeType employeeType;
    private int totalVacationDays;
    private int usedVacationDays;
    private boolean isOnVacation;
    private Date hireDate;
    private Date quitDate;
    private boolean wasDismissed;

    private PersonalInformation personalInformation;
    private WorkContact workContact;
    private Teacher teacher;
    private Set<Salary> salaries;
    private User user;

    public Employee() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", columnDefinition = "ENUM('TEACHER', 'PRINCIPAL', 'JANITOR', 'COOK') DEFAULT 'TEACHER'")
    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    @Column(name = "total_vacation_days", nullable = false, length = 2)
    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(int totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }
    @Column(name = "used_vacation_days", length = 2, columnDefinition = "int DEFAULT 0")
    public int getUsedVacationDays() {
        return usedVacationDays;
    }

    public void setUsedVacationDays(int usedVacationDays) {
        this.usedVacationDays = usedVacationDays;
    }

    @Column(name = "is_on_vacation", columnDefinition = "bit DEFAULT 0")
    public boolean isOnVacation() {
        return isOnVacation;
    }

    public void setOnVacation(boolean onVacation) {
        isOnVacation = onVacation;
    }

    @Column(name = "hire_date")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "quit_date")
    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    @Column(name = "was_dismissed", columnDefinition = "bit DEFAULT 0")
    public boolean getWasDismissed() {
        return wasDismissed;
    }

    public void setWasDismissed(boolean wasDismissed) {
        this.wasDismissed = wasDismissed;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_information_id")
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_contact_id")
    public WorkContact getWorkContact() {
        return workContact;
    }

    public void setWorkContact(WorkContact workContact) {
        this.workContact = workContact;
    }

    @OneToOne(mappedBy = "employee")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToMany(mappedBy = "employee")
    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    @OneToOne(mappedBy = "employee")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
