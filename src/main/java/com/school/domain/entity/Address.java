package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", columnDefinition = "ENUM('PRIMARY', 'SECONDARY') DEFAULT 'PRIMARY'")
    private AddressType addressType;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 50)
    private String area;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 5)
    private String block;
}
