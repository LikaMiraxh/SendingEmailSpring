package com.example.email.service;

import com.example.email.pojo.entity.Invoice;
import com.example.email.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultInvoiceService implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findInvoiceById(Integer iid) {
        if(iid == null) {
            return null;
        }
        return invoiceRepository.findInvoiceByIid(iid);
    }

    @Override
    public void delete(Integer iid) {
        invoiceRepository.deleteById(iid);
    }

    @Override
    public Integer countByIspaidFalse() {
        return invoiceRepository.countByIspaidFalse();
    }

    @Override
    public List<Invoice> findInvoicesByIsPaid(Boolean ispaid) {
        return invoiceRepository.findInvoicesByIsPaid(ispaid);
    }

    @Override
    public List<Invoice> findInvoicesByReceptionistRname(String rname) {
        return invoiceRepository.findInvoicesByReceptionistRname(rname);
    }
}
