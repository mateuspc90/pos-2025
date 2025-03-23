package inatel.dm112.logistica.adapter.impl;

import org.springframework.stereotype.Component;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
//import com.sendgrid.helpers.mail.objects.Attachments;
//import java.util.Base64;

import inatel.dm112.logistica.adapter.MailAdapter;
import inatel.dm112.logistica.adapter.MailData;

@Component
public class MailAdapterImpl implements MailAdapter {
    
    @Override
    public void sendMail(MailData mailData) throws Exception {
        Email from = new Email(mailData.getFrom());
        Email to = new Email(mailData.getTo());
        String subject = "Confirmação de Entrega - Pedido " + mailData.getOrderNumber();
        Content content = new Content("text/plain",mailData.getContent());
        
        Mail mail = new Mail(from, subject, to, content);
        
        SendGrid sg = new SendGrid(mailData.getSendgridAPIKey());
        Request request = new Request();
        
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            
            Response response = sg.api(request);
            
            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                System.out.println("Email enviado com sucesso. Status: " + response.getStatusCode());
            } else {
                throw new Exception("Erro ao enviar email. Status: " + response.getStatusCode() + 
                                  ", Corpo: " + response.getBody());
            }
        } catch (Exception e) {
            System.err.println("Erro no envio de email: " + e.getMessage());
            throw e;
        }
    }
}