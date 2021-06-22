package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Salary extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "ENUM('CASH', 'CARD', 'CHEQUE') DEFAULT 'CARD'")
    private PaymentMethod paymentMethod;

    @Column(scale = 6, precision = 2, nullable = false)
    private float gross;

    @Column(scale = 6, precision = 2, nullable = false)
    private float net;

    @Column(scale = 6, precision = 2)
    private float bonus;

    @Formula("net + bonus")
    @Column(scale = 6, precision = 2, nullable = false)
    private float total;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "salaries")
    private Employee employee;
}
