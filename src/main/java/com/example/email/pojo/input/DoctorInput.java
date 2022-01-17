package com.example.email.pojo.input;

public class DoctorInput {

    private String dname;
    private String demail;

    public DoctorInput(String dname, String demail) {
        this.dname = dname;
        this.demail = demail;
    }

    public DoctorInput() {
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
}
