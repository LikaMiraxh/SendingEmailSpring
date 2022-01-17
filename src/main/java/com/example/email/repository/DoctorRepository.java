package com.example.email.repository;

import com.example.email.pojo.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    List<Doctor> findAll();
    Doctor findDoctorByDid(Integer did);

    Doctor findDoctorsByDname(String dname);

    @Query(
            "SELECT COUNT(p.pid) FROM Patient p "+
                    "JOIN FETCH Doctor d on d.did = p.doctor.did "+
                    "WHERE d.dname = :dname"
    )
    Integer countPatientsByDoctorDname(@Param("dname") String dname);
}
