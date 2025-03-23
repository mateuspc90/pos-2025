package inatel.dm112.logistica.adapter.impl;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import inatel.dm112.logistica.adapter.MailAdapter;
import inatel.dm112.logistica.adapter.MailData;

@Component
public class MailAdapterImpl implements MailAdapter {
    
    @Override
    public void sendMail(MailData mailData) throws Exception {
        // Configurações do servidor de email (Gmail)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        // Criando a sessão com autenticação
        // Para Gmail, você precisará de um email e senha de aplicativo (não senha normal)
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailData.getFrom(), mailData.getFromPassword());
            }
        });
        
        try {
            // Criando a mensagem
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailData.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailData.getTo()));
            message.setSubject("Confirmação de Entrega - Pedido " + mailData.getOrderNumber());
            message.setText(mailData.getContent());
            
            // Enviando a mensagem
            Transport.send(message);
            
            System.out.println("Email enviado com sucesso.");
        } catch (MessagingException e) {
            System.err.println("Erro no envio de email: " + e.getMessage());
            throw new Exception("Erro ao enviar email: " + e.getMessage(), e);
        }
    }
}