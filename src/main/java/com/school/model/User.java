package com.school.model;

import com.school.model.base.BaseEntity;
import com.school.model.enums.UserStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class User extends BaseEntity {
    private String username;
    private String password;
    private UserStatus userStatus;
    private int failedLoginAttempts;
    private Date lastLogin;
    private Employee employee;

    public User() {
    }


    @Column(length = 50, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'BLOCKED') DEFAULT 'ACTIVE'")
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Column(name = "failed_login_attempts", length = 1)
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    @Column(name = "last_login", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
