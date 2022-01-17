package com.example.email.controller;

import com.example.email.pojo.entity.Doctor;
import com.example.email.pojo.input.DoctorInput;
import com.example.email.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor")
    public List<Doctor> getDoctors(){
        return doctorService.findAll();
    }

    @GetMapping("/doctor/{did}")
    public Doctor findDoctor(@PathVariable Integer did){
        return doctorService.findDoctorById(did);
    }

    @PostMapping("doctor")
    public Doctor insertNewDoctor(@RequestBody DoctorInput doctorInput){
        return doctorService.save(doctorInput);
    }

    @DeleteMapping("/doctor/{did}")
    public Boolean deleteDoctor(@PathVariable Integer did){
        doctorService.delete(did);
        return true;
    }

    @PutMapping("/doctor/{did}")
    public Doctor updateDoctor(@PathVariable Integer did,
                               @RequestBody DoctorInput doctorInput){
    return doctorService.update(did,doctorInput);
    }

    @GetMapping("/doctor/findbydname/{dname}")
    public Doctor findDoctorByDname(@PathVariable String dname){
        return doctorService.findDoctorsByDname(dname);
    }


    @GetMapping("/doctor/countpatients/{dname}")
    public Integer countPatientsByDoctorDname(@PathVariable String dname){
        return doctorService.countPatientsByDoctorDname(dname);
    }

}
