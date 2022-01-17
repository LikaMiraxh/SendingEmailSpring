package com.example.email.service;

import com.example.email.pojo.entity.Doctor;
import com.example.email.pojo.input.DoctorInput;
import com.example.email.repository.DoctorRepository;
import com.example.email.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDoctorService implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findDoctorById(Integer did) {
        if(did == null) {
            return null;
        }
        return doctorRepository.findDoctorByDid(did);
    }

    @Override
    public Doctor save(DoctorInput doctorInput) {
        String dname = doctorInput.getDname();
        String demail = doctorInput.getDemail();

        Doctor doctor = new Doctor();
        doctor.setDname(dname);
        doctor.setDemail(demail);

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Integer did, DoctorInput doctorInput) {
        Doctor doctor = doctorRepository.findDoctorByDid(did);
        if(doctor == null){
            return null;
        }

        String updatedDname = doctorInput.getDname();
        String updatedDemail = doctorInput.getDemail();

        doctor.setDname(updatedDname);
        doctor.setDemail(updatedDemail);

        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(Integer did) {
        doctorRepository.deleteById(did);
    }

    @Override
    public Doctor findDoctorsByDname(String dname) {
        return doctorRepository.findDoctorsByDname(dname);
    }

    @Override
    public Integer countPatientsByDoctorDname(String dname) {
        return doctorRepository.countPatientsByDoctorDname(dname);
    }
}
