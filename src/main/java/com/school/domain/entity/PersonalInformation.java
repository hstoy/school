package com.school.domain.entity;

import com.school.domain.base.BaseEntity;
import com.school.domain.enums.Gender;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "personal_information")
public class PersonalInformation extends BaseEntity {

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE')")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "personalInformation")
    private Employee employee;

    @OneToMany(mappedBy = "personalInformation")
    private Set<Address> address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private PersonalContact personalContact;

    @OneToOne(mappedBy = "personalInformation")
    private Student student;

    @OneToOne(mappedBy = "personalInformation")
    private Parent parent;
}
