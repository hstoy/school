package com.school.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ContactBaseEntity extends BaseEntity {

    @Getter
    @Setter
    @Column(unique = true, length = 50)
    private String email;

    @Getter
    @Setter
    @Column(unique = true, length = 20)
    private String mobile;
}
