package com.example.email.pojo.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

//pzfxgeyiyydhnkjd
@Entity
@Table(name = "receptionist")
public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer rid;

    @Column(name = "rname")
    private String rname;

    @Column(name = "remail")
    private String remail;

    @OneToMany(mappedBy = "receptionist")
    @JsonManagedReference
    private List<Invoice> invoices;


    public Receptionist() {
    }

    public Receptionist(Integer rid, String rname, String remail) {
        this.rid = rid;
        this.rname = rname;
        this.remail = remail;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
