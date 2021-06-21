package com.school.domain.entity;

import com.school.domain.base.ContactBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "personal_contact")
public class PersonalContact extends ContactBaseEntity {

    @Getter
    @Setter
    @Column(length = 20)
    private String phone;

    @Getter
    @Setter
    @Column(length = 20, nullable = false)
    private String emergency;

    @Getter
    @Setter
    @OneToOne(mappedBy = "personalContact")
    private PersonalInformation personalInformation;
}
