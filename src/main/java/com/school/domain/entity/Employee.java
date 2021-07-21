package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.EmployeeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table
public class Employee extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", columnDefinition = "ENUM('TEACHER', 'PRINCIPAL', 'JANITOR', 'COOK') DEFAULT 'TEACHER'")
    private EmployeeType employeeType;

    @Column(name = "total_vacation_days", nullable = false, length = 2)
    private int totalVacationDays;

    @Column(name = "used_vacation_days", length = 2, columnDefinition = "int DEFAULT 0")
    private int usedVacationDays;

    @Column(name = "is_on_vacation", columnDefinition = "bit DEFAULT 0")
    private boolean isOnVacation;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "quit_date")
    private Date quitDate;

    @Column(name = "was_dismissed", columnDefinition = "bit DEFAULT 0")
    private boolean wasDismissed;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "work_contact_id")
    private WorkContact workContact;
}
