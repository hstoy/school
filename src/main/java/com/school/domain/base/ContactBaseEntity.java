package com.school.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class ContactBaseEntity extends BaseEntity {

    @Column(unique = true, length = 50)
    private String email;

    @Column(unique = true, length = 20)
    private String mobile;
}
