package com.br.eduardosimass.servidoremail.service;

import com.br.eduardosimass.servidoremail.model.Email;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.when;

@MockitoSettings
class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    public void EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Test
    void testEmailService() throws Exception {
        Email emailBuilder = new Email("eduardo@eduardo.com.br", "Teste de Envio", "Teste deve enviar");

        EmailService emailService = new EmailService(mailSender);
        var message = new SimpleMailMessage();
        emailService.enviableEmail(emailBuilder);
    }


}