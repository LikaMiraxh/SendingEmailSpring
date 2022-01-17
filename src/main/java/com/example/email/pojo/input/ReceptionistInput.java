package com.example.email.pojo.input;

public class ReceptionistInput {

    private String rname;
    private String remail;

    public ReceptionistInput(String rname, String remail) {
        this.rname = rname;
        this.remail = remail;
    }

    public ReceptionistInput() {
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
}
