package com.school.model;

import com.school.model.base.ContactBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "personal_contact")
public class PersonalContact extends ContactBaseEntity {
    private String phone;
    private String emergency;

    private PersonalInformation personalInformation;

    public PersonalContact() {
    }

    @Column(length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(length = 20, nullable = false)
    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    @OneToOne(mappedBy = "personalContact")
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
}
