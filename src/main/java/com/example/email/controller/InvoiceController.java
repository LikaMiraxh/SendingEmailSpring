package com.example.email.controller;

import com.example.email.pojo.entity.Invoice;
import com.example.email.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoice")
    public List<Invoice> getInvoices(){
        return invoiceService.findAll();
    }

    @GetMapping("/invoice/{iid}")
    public Invoice findInvoice(@PathVariable Integer iid){
        return invoiceService.findInvoiceById(iid);
    }

    @DeleteMapping("/invoice/{iid}")
    public Boolean deleteInvoice(@PathVariable Integer iid){
        invoiceService.delete(iid);
        return true;
    }

    @GetMapping("/invoice/countnotpaid")
    public Integer countInvoicesWhichAreNotPaid(){
        return invoiceService.countByIspaidFalse();
    }


    @GetMapping("/invoice/rname/{rname}")
    public List<Invoice> findInvoicesByReceptionistRname(@PathVariable String rname){
        return invoiceService.findInvoicesByReceptionistRname(rname);
    }

    @GetMapping("/invoice/ispaid/{ispaid}")
    public List<Invoice> findInvoicesByStatus(@PathVariable Boolean ispaid){
        return invoiceService.findInvoicesByIsPaid(ispaid);
    }

}

