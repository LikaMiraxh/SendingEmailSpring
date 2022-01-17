package com.example.email.pojo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "pemail")
    private String pemail;

    @ManyToOne
    @JoinColumn(name = "doctor_did")
    @JsonBackReference
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<Invoice> invoices;

    public Patient() {
    }

    public Patient(Integer pid, String pname, String pemail) {
        this.pid = pid;
        this.pname = pname;
        this.pemail = pemail;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
