package com.example.employeedatabasedetails.Entity;

import lombok.*;


import javax.persistence.*;



@Entity
@Data
@Getter
@Setter
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "dob")
    private  String dob;
    @Column(name = "phone")
    private String phoneno;
    @Column(name = "fileName")
    private String fileName;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeeId, String name, String email, String dob, String phoneno, String fileName) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phoneno = phoneno;
        this.fileName = fileName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", phoneno='" + phoneno + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
