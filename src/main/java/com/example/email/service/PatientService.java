package com.example.email.service;

import com.example.email.pojo.entity.Patient;
import com.example.email.pojo.input.PatientInput;

import java.util.List;

public interface PatientService {

    List<Patient> findAll();
    Patient findPatientById(Integer pid);
    Patient save(PatientInput patientInput);
    Patient update(Integer pid, PatientInput patientInput);
    void delete(Integer pid);

    List <Patient> findPatientsByPnameStartingWith(String startletter);

    List<Patient> findPatientsByInvoicesContains(Boolean ispaid);
}
