package com.example.email.repository;

import com.example.email.pojo.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    List<Patient> findAll();
    Patient findPatientByPid(Integer pid);

    List <Patient> findPatientsByPnameStartingWith(String startletter);

    @Query(
            "SELECT p FROM Patient p "+
                    "JOIN FETCH Invoice i ON i.patient.pid = p.pid "+
                    "WHERE i.ispaid = :ispaid"
    )
    List<Patient> findPatientsByInvoicesContains(@Param("ispaid") Boolean ispaid);
}
