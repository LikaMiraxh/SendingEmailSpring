package com.example.email.pojo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iid")
    private Integer iid;

    @Column(name = "ispaid")
    private Boolean ispaid;

    @ManyToOne
    @JoinColumn(name = "receptionist_rid")
    @JsonBackReference
    private Receptionist receptionist;

    @ManyToOne
    @JoinColumn(name = "patient_pid")
    @JsonBackReference
    private Patient patient;

    public Invoice() {
    }

    public Invoice(Integer iid, Boolean isPaid) {
        this.iid = iid;
        this.ispaid = isPaid;
    }

    public Invoice(Integer iid) {
        this.iid = iid;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public boolean getPaid() {
        return ispaid;
    }

    public void setPaid(Boolean paid) {
        ispaid = paid;
    }

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
