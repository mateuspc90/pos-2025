package inatel.dm112.logistica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import inatel.dm112.logistica.adapter.MailAdapter;
import inatel.dm112.logistica.adapter.MailData;
import inatel.dm112.logistica.model.MailRequestData;
import inatel.dm112.logistica.rest.support.UtilityException;

@Component
public class MailService {
    
    @Value("${email.fromAddress}")
    private String emailFromAddress;
    
    @Value("${email.fromPassword}")
    private String emailFromPassword;
    
    @Value("${twilio.sendgrid.api.key}")
    private String sendgridAPIKey;
    
    @Autowired
    MailAdapter sender;

    public void sendMail(MailRequestData mailReq) {
        if (mailReq.getTo() == null || 
            mailReq.getContent() == null) {
            throw new UtilityException("Null values not allowed in MailData.");
        }
        
        MailData mailData = new MailData(
                mailReq.getOrderNumber(), emailFromAddress, emailFromPassword, 
                mailReq.getTo(), mailReq.getContent());

        //set credentials
        mailData.setSendgridAPIKey(sendgridAPIKey);
        
        try {
            sender.sendMail(mailData);
        } catch(Exception e) {
            e.printStackTrace();
            throw new UtilityException("Error sending email: " + e.getMessage());
        }
        System.out.println("Email sent success.");
    }
}