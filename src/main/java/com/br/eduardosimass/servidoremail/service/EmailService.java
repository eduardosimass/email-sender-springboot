package com.br.eduardosimass.servidoremail.service;

import com.br.eduardosimass.servidoremail.model.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviableEmail(Email email){
       var message = new SimpleMailMessage();
       message.setFrom("noreply@gmail.com");
       message.setTo(email.To());
       message.setSubject(email.Subject());
       message.setText(email.body());
       mailSender.send(message);
    }
}
