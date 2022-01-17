package com.example.email.pojo.input;

public class PatientInput {

    private String pname;
    private String pemail;

    public PatientInput(String pname, String pemail) {
        this.pname = pname;
        this.pemail = pemail;
    }

    public PatientInput() {
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
}
