package com.example.email.config;

import com.example.email.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesAutoConfiguration {

    @Bean
    public DoctorService doctorService(){
        return new DefaultDoctorService();
    }

    @Bean
    public InvoiceService invoiceService(){
        return new DefaultInvoiceService();
    }

    @Bean
    public PatientService patientService(){
        return new DefaultPatientService();
    }

    @Bean
    public ReceptionistService receptionistService(){
        return new DefaultReceptionistService();
    }
}
