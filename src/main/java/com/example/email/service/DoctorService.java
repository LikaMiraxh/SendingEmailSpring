package com.example.email.service;

import com.example.email.pojo.entity.Doctor;
import com.example.email.pojo.input.DoctorInput;

import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();
    Doctor findDoctorById(Integer did);
    Doctor save(DoctorInput doctorInput);
    Doctor update(Integer did, DoctorInput doctorInput);
    void delete(Integer did);
    Doctor findDoctorsByDname(String dname);

    Integer countPatientsByDoctorDname(String dname);

}
