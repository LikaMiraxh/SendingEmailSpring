package com.example.email.pojo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Integer did;

    @Column(name = "dname")
    private String dname;

    @Column(name = "demail")
    private String demail;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Patient> patients;


    public Doctor() {
    }

    public Doctor(String dname, String demail){
        this.dname = dname;
        this.demail = demail;
    }

    public Doctor(Integer did, String dname, String demail) {
        this.did = did;
        this.dname = dname;
        this.demail = demail;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
