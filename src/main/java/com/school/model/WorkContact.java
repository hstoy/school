package com.school.model;

import com.school.model.base.ContactBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "work_contact")
public class WorkContact extends ContactBaseEntity {
    private String roomNumber;
    private boolean isValid;

    private Employee employee;

    public WorkContact() {
    }

    @Column(name = "room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "is_valid")
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @OneToOne(mappedBy = "workContact")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
