package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Address extends BaseEntity {

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", columnDefinition = "ENUM('PRIMARY', 'SECONDARY') DEFAULT 'PRIMARY'")
    private AddressType addressType;

    @Getter
    @Setter
    @Column(nullable = false, length = 50)
    private String city;

    @Getter
    @Setter
    @Column(length = 50)
    private String area;

    @Getter
    @Setter
    @Column(nullable = false, length = 100)
    private String street;

    @Getter
    @Setter
    @Column(nullable = false, length = 5)
    private String block;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "address")
    private PersonalInformation personalInformation;
}
