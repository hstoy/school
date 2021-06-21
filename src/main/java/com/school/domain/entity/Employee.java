package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.EmployeeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Employee extends BaseEntity {

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", columnDefinition = "ENUM('TEACHER', 'PRINCIPAL', 'JANITOR', 'COOK') DEFAULT 'TEACHER'")
    private EmployeeType employeeType;

    @Getter
    @Setter
    @Column(name = "total_vacation_days", nullable = false, length = 2)
    private int totalVacationDays;

    @Getter
    @Setter
    @Column(name = "used_vacation_days", length = 2, columnDefinition = "int DEFAULT 0")
    private int usedVacationDays;

    @Getter
    @Setter
    @Column(name = "is_on_vacation", columnDefinition = "bit DEFAULT 0")
    private boolean isOnVacation;

    @Getter
    @Setter
    @Column(name = "hire_date")
    private Date hireDate;

    @Getter
    @Setter
    @Column(name = "quit_date")
    private Date quitDate;

    @Getter
    @Setter
    @Column(name = "was_dismissed", columnDefinition = "bit DEFAULT 0")
    private boolean wasDismissed;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_contact_id")
    private WorkContact workContact;

    @Getter
    @Setter
    @OneToOne(mappedBy = "employee")
    private Teacher teacher;

    @Getter
    @Setter
    @OneToMany(mappedBy = "employee")
    private Set<Salary> salaries;

    @Getter
    @Setter
    @OneToOne(mappedBy = "employee")
    private User user;
}
