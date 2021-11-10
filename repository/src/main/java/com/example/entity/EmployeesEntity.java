package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeesEntity {
    @Id
    @GeneratedValue
    private Long empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date hireDate;

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}

enum Gender {
    M("M"),
    F("F");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}