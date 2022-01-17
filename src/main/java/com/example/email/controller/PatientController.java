package com.example.email.controller;

import com.example.email.pojo.entity.Patient;
import com.example.email.pojo.input.PatientInput;
import com.example.email.repository.PatientRepository;
import com.example.email.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<Patient> getPatients(){
        return patientService.findAll();
    }

    @GetMapping("/patient/{pid}")
    public Patient findPatient(@PathVariable Integer pid){
        return patientService.findPatientById(pid);
    }

    @PostMapping("/patient")
    public Patient insertPatient(@RequestBody PatientInput patientInput){
        return patientService.save(patientInput);
    }

    @DeleteMapping("/patient/{pid}")
    public Boolean deletePatient(@PathVariable Integer pid){
        patientService.delete(pid);
        return true;
    }

    @PutMapping("/patient/{pid}")
    public Patient updatePatient(@PathVariable Integer pid,
                                 @RequestBody PatientInput patientInput){
        return patientService.update(pid,patientInput);
    }

    @GetMapping("/patient/namestartswith/{startletter}")
    public List<Patient> findPatientsByStartingNameLetter(@PathVariable String startletter){
        return patientService.findPatientsByPnameStartingWith(startletter);
    }

    @GetMapping("/patient/invoicestatus/{ispaid}")
    public List<Patient> findPatientsByInvoiceStatus(@PathVariable Boolean ispaid){
        return patientService.findPatientsByInvoicesContains(ispaid);
    }
}
