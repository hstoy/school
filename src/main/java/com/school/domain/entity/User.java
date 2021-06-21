package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
