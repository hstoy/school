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

@Entity
@Table(name = "personal_information")
public class PersonalInformation extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Getter
    @Setter
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE', 'FEMALE')")
    private Gender gender;

    @Getter
    @Setter
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Getter
    @Setter
    @OneToOne(mappedBy = "personalInformation")
    private Employee employee;

    @Getter
    @Setter
    @OneToMany(mappedBy = "personalInformation")
    private Set<Address> address;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private PersonalContact personalContact;

    @Getter
    @Setter
    @OneToOne(mappedBy = "personalInformation")
    private Student student;

    @Getter
    @Setter
    @OneToOne(mappedBy = "personalInformation")
    private Parent parent;
}
