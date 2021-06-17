package com.school.entity;

import com.school.entity.enums.EmployeeType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    private EmployeeType employeeType;
    private PersonalInformation personalInformation;
    private Teacher teacher;
    private int totalVacationDays;
    private int usedVacationDays;
    private boolean isOnVacation;
    private Date hireDate;
    private Date quitDate;
    private boolean wasDismissed;

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

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @OneToOne(mappedBy = "employee")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Column(name = "total_vacation_days", nullable = false)
    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(int totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    @Column(name = "used_vacation_days", columnDefinition = "int DEFAULT 0")
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

    @Column(name = "was_dismissed")
    public boolean wasDismissed() {
        return wasDismissed;
    }

    public void setWasDismissed(boolean wasDismissed) {
        this.wasDismissed = wasDismissed;
    }
}
