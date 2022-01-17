package com.example.email.service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MailService {

    void sendMail (List<String> to, String subject, String template, Map<String, String> params, String from) throws MessagingException, IOException;
}
