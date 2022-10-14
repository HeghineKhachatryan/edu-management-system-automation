package com.epam.jdbc.model;

import java.util.Date;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String email;

    private String address;

    private String gender;

    private String bloodGroup;

    private String linkedParent;

    private String linkedClass;

    private Date birthDay;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", linkedParent='" + linkedParent + '\'' +
                ", linkedClass='" + linkedClass + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
