package com.example.email.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DefaultMailService implements MailService {

    public static final String MAIL_PATH = "mail/";
    private final JavaMailSender mailSender;
    public String sender;

    public DefaultMailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    @Async
    @Override
    public void sendMail(List<String> to, String subject, String template, Map<String, String> params, String email) throws MessagingException, IOException {
        sender = email;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");

        String htmlBody = composeBody(template, params);

        to.forEach(receiver->{
            try{
                mimeMessageHelper.setFrom(sender);
                mimeMessageHelper.setTo(receiver);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(htmlBody, true);

                mailSender.send(message);

            }catch(MessagingException e){
                e.getMessage();
            }
        });
    }

    private String composeBody(String template, Map<String, String> params) throws IOException{

        InputStream resource = new ClassPathResource(MAIL_PATH + template).getInputStream();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(resource))){
         String content = reader.lines().collect(Collectors.joining("\n"));

         for(Map.Entry<String, String> entry : params.entrySet()){
             content = content.replaceAll(String.format("\\{\\{%s\\}\\}", entry.getKey()), entry.getValue());
         }
         return content;
        }
    }
}
