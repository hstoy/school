package com.school.entity;

import com.school.entity.base.BaseEntity;
import com.school.entity.enums.PaymentMethod;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Salary extends BaseEntity {
    private PaymentMethod paymentMethod;
    private float gross;
    private float net;
    private float bonus;
    private float total;
    private Date paymentDate;

    private Employee employee;

    public Salary() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "ENUM('CASH', 'CARD', 'CHEQUE') DEFAULT 'CARD'")
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Column(scale = 6, precision = 2, nullable = false)
    public float getGross() {
        return gross;
    }

    public void setGross(float gross) {
        this.gross = gross;
    }

    @Column(scale = 6, precision = 2, nullable = false)
    public float getNet() {
        return net;
    }

    public void setNet(float net) {
        this.net = net;
    }

    @Column(scale = 6, precision = 2)
    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    @Column(scale = 6, precision = 2, nullable = false)
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Column(name = "payment_date", nullable = false)
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @ManyToOne
    @JoinColumn(name = "salaries")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
