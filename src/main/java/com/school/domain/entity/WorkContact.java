package com.school.domain.entity;

import com.school.domain.base.ContactBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "work_contact")
public class WorkContact extends ContactBaseEntity {

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "is_valid")
    private boolean isValid;

    @OneToOne(mappedBy = "workContact")
    private Employee employee;
}
