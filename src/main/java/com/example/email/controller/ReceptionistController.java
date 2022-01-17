package com.example.email.controller;

import com.example.email.exceptions.EmailSendingException;
import com.example.email.pojo.entity.Receptionist;
import com.example.email.pojo.input.ReceptionistInput;
import com.example.email.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceptionistController {

    @Autowired
    private ReceptionistService receptionistService;

    @GetMapping("/receptionist")
    public List<Receptionist> getReceptionists() {
        return receptionistService.findAll();
    }

    @GetMapping("/receptionist/{rid}")
    public Receptionist findReceptionist(@PathVariable Integer rid) {
        return receptionistService.findReceptionistById(rid);
    }

    @PostMapping("/receptionist")
    public Receptionist insertNewReceptionist(@RequestBody ReceptionistInput receptionistInput) {
        return receptionistService.save(receptionistInput);
    }

    @DeleteMapping("/receptionist/{rid}")
    public Boolean deleteReceptionist(@PathVariable Integer rid) {
        receptionistService.delete(rid);
        return true;
    }

    @PutMapping("/receptionist/{rid}")
    public Receptionist updateReceptionist(@PathVariable Integer rid,
                                           @RequestBody ReceptionistInput receptionistInput) {
        return receptionistService.update(rid, receptionistInput);
    }

    @PostMapping("/mail/reminder")
    public void sendInvoiceByMail(@RequestParam("pid") Integer Pid,
                                  @RequestParam("message") String message) throws EmailSendingException {
        receptionistService.sendInvoiceToPatient(Pid, message);
    }
}
