package com.example.email.service;

import com.example.email.pojo.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();
    Invoice findInvoiceById(Integer iid);
    void delete(Integer iid);
    Integer countByIspaidFalse();
    List<Invoice> findInvoicesByIsPaid(Boolean ispaid);
    List<Invoice> findInvoicesByReceptionistRname(String rname);

}