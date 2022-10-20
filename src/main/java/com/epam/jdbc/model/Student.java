package com.epam.jdbc.model;

import java.util.Date;

public class Student extends User {

    private String address;

    private String gender;

    private String bloodGroup;

    private String linkedParent;

    private String linkedClass;

    private Date birthDay;


    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getLinkedParent() {
        return linkedParent;
    }

    public String getLinkedClass() {
        return linkedClass;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setLinkedParent(String linkedParent) {
        this.linkedParent = linkedParent;
    }

    public void setLinkedClass(String linkedClass) {
        this.linkedClass = linkedClass;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
