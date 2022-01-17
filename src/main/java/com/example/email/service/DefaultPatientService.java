package com.example.email.service;

import com.example.email.pojo.entity.Patient;
import com.example.email.pojo.input.PatientInput;
import com.example.email.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPatientService implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(Integer pid) {
        if(pid == null) {
            return null;
        }
        return patientRepository.findPatientByPid(pid);
    }

    @Override
    public Patient save(PatientInput patientInput) {
        String pname = patientInput.getPname();
        String pemail = patientInput.getPemail();

        Patient patient = new Patient();
        patient.setPname(pname);
        patient.setPemail(pemail);

        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Integer pid, PatientInput patientInput) {
        Patient patient = patientRepository.findPatientByPid(pid);
        if(patient == null){
            return null;
        }

        String updatedPname = patientInput.getPname();
        String updatedPemail = patientInput.getPemail();

        patient.setPname(updatedPname);
        patient.setPemail(updatedPemail);

        return patientRepository.save(patient);
    }

    @Override
    public void delete(Integer pid) {
        patientRepository.deleteById(pid);
    }

    @Override
    public List<Patient> findPatientsByPnameStartingWith(String startletter) {
        return patientRepository.findPatientsByPnameStartingWith(startletter);
    }

    @Override
    public List<Patient> findPatientsByInvoicesContains(Boolean ispaid) {
        return patientRepository.findPatientsByInvoicesContains(ispaid);
    }
}
