package com.example.email.service;

import com.example.email.exceptions.EmailSendingException;
import com.example.email.pojo.entity.Patient;
import com.example.email.pojo.entity.Receptionist;
import com.example.email.pojo.input.ReceptionistInput;
import com.example.email.repository.PatientRepository;
import com.example.email.repository.ReceptionistRepository;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultReceptionistService implements ReceptionistService{

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment env;

    @Override
    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();
    }

    @Override
    public Receptionist findReceptionistById(Integer rid) {
        if(rid == null ) {
            return null;
        }
        return receptionistRepository.findReceptionistByRid(rid);
    }

    @Override
    public Receptionist save(ReceptionistInput receptionistInput) {
        String rname = receptionistInput.getRname();
        String remail = receptionistInput.getRemail();

        Receptionist receptionist = new Receptionist();
        receptionist.setRname(rname);
        receptionist.setRemail(remail);

        return receptionistRepository.save(receptionist);
    }

    @Override
    public Receptionist update(Integer rid, ReceptionistInput receptionistInput) {
        Receptionist receptionist = receptionistRepository.findReceptionistByRid(rid);
        if(receptionist == null) {
            return null;
        }

        String updatedRname = receptionistInput.getRname();
        String updatedRemail = receptionistInput.getRname();

        receptionist.setRname(updatedRname);
        receptionist.setRemail(updatedRemail);

        return receptionistRepository.save(receptionist);
    }

    @Override
    public void delete(Integer rid) {
        receptionistRepository.deleteById(rid);
    }


    public void sendInvoiceToPatient(Integer Pid, String message) throws EmailSendingException {
        String from = env.getProperty("spring.mail.username");
        Patient patientToSendMail = patientRepository.findPatientByPid(Pid);
        List<String> emails = new ArrayList<>();

        emails.add(patientToSendMail.getPemail());

        //In case if we want to send email to multiple users
       /* patientsToSendMail.forEach(patient -> {
            emails.add(patient.getPemail());
        });*/

        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        try {
            mailService.sendMail(emails, "Invoice", "invoice.html", map, from);
        } catch (Exception e) {
            throw new EmailSendingException();
        }
    }

}
