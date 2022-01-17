package com.example.email.repository;

import com.example.email.pojo.entity.Receptionist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptionistRepository extends CrudRepository<Receptionist, Integer> {

    List<Receptionist> findAll();
    Receptionist findReceptionistByRid(Integer rid);

}
