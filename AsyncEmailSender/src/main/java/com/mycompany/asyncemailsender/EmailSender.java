package com.mycompany.asyncemailsender;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {
    public static void sendEmail(String to, String subject, String content) {
        // .env dosyasını yüklendi
        Dotenv dotenv = Dotenv.load();

        final String username = dotenv.get("EMAIL_USERNAME"); 
        final String password = dotenv.get("EMAIL_PASSWORD"); 

        if (username == null || password == null) {
            throw new RuntimeException("E-posta kullanıcı adı veya şifre .env dosyasında bulunamadı!");
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);
            System.out.println("Email sent successfully to: " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
