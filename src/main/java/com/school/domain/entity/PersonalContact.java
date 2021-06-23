package com.school.domain.entity;

import com.school.domain.base.ContactBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "personal_contact")
public class PersonalContact extends ContactBaseEntity {

    @Column(length = 20)
    private String phone;

    @Column(length = 20, nullable = false)
    private String emergency;
}
