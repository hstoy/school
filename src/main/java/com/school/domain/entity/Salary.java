package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Salary extends BaseEntity {

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "ENUM('CASH', 'CARD', 'CHEQUE') DEFAULT 'CARD'")
    private PaymentMethod paymentMethod;

    @Getter
    @Setter
    @Column(scale = 6, precision = 2, nullable = false)
    private float gross;

    @Getter
    @Setter
    @Column(scale = 6, precision = 2, nullable = false)
    private float net;

    @Getter
    @Setter
    @Column(scale = 6, precision = 2)
    private float bonus;

    @Getter
    @Setter
    @Column(scale = 6, precision = 2, nullable = false)
    private float total;

    @Getter
    @Setter
    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "salaries")
    private Employee employee;
}
