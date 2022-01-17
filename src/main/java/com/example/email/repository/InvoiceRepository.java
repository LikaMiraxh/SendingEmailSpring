package com.example.email.repository;

import com.example.email.pojo.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
    List<Invoice> findAll();
    Invoice findInvoiceByIid(Integer iid);

    Integer countByIspaidFalse();

    List<Invoice> findInvoicesByReceptionistRname(String rname);

    @Query(
            "SELECT i FROM Invoice i WHERE i.ispaid = :ispaid"
    )
    List<Invoice> findInvoicesByIsPaid(@Param ("ispaid") Boolean ispaid);





}
