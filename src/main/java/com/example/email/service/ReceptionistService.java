package com.example.email.service;

import com.example.email.exceptions.EmailSendingException;
import com.example.email.pojo.entity.Receptionist;
import com.example.email.pojo.input.ReceptionistInput;

import java.util.List;

public interface ReceptionistService {

    List<Receptionist> findAll();
    Receptionist findReceptionistById(Integer rid);
    Receptionist save(ReceptionistInput receptionistInput);
    Receptionist update(Integer rid, ReceptionistInput receptionistInput);
    void delete(Integer rid);

    void sendInvoiceToPatient(Integer rid, String message) throws EmailSendingException;

}
