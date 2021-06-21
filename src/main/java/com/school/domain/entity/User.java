package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class User extends BaseEntity {

    @Getter
    @Setter
    @Column(length = 50, unique = true)
    private String username;

    @Getter
    @Setter
    @Column(length = 50)
    private String password;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'BLOCKED') DEFAULT 'ACTIVE'")
    private UserStatus userStatus;

    @Getter
    @Setter
    @Column(name = "failed_login_attempts", length = 1)
    private int failedLoginAttempts;

    @Getter
    @Setter
    @Column(name = "last_login", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date lastLogin;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
