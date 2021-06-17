package com.school.entity;

import com.school.entity.enums.AddressType;

import javax.persistence.*;

@Entity
@Table
public class Address extends BaseEntity {
    private PersonalInformation personalInformation;
    private AddressType addressType;
    private String city;
    private String area;
    private String street;
    private String block;

    public Address() {
    }

    @ManyToOne
    @PrimaryKeyJoinColumn
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", columnDefinition = "ENUM('PRIMARY', 'SECONDARY') DEFAULT 'PRIMARY'")
    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(nullable = false)
    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
