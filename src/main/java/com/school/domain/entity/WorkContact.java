package com.school.domain.entity;

import com.school.domain.base.ContactBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work_contact")
public class WorkContact extends ContactBaseEntity {

    @Getter
    @Setter
    @Column(name = "room_number")
    private String roomNumber;

    @Getter
    @Setter
    @Column(name = "is_valid")
    private boolean isValid;

    @Getter
    @Setter
    @OneToOne(mappedBy = "workContact")
    private Employee employee;
}
