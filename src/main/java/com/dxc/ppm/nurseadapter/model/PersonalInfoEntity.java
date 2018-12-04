package com.dxc.ppm.nurseadapter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PersonalInfo")
public class PersonalInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PATIENT_ID", nullable = false)
    private String patientId;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "DOB", nullable = false)
    private Date dob;

    @Column(name = "SEX", nullable = false)
    private String sex;

    @Column(name = "POB", nullable = false)
    private String pob;

    @Column(name = "DELETED", nullable = false)
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}