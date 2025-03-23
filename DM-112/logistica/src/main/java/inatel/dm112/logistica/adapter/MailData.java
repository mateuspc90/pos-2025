package inatel.dm112.logistica.adapter;

public class MailData {
    private int orderNumber;
    private String from;
    private String fromPassword;
    private String to;
    private String content;
    private String sendgridAPIKey;
    
    public MailData(int orderNumber, String from, String fromPassword, String to, String content) {
        this.orderNumber = orderNumber;
        this.from = from;
        this.fromPassword = fromPassword;
        this.to = to;
        this.content = content;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String getFrom() {
        return from;
    }
    
    public String getFromPassword() {
        return fromPassword;
    }
    
    public String getTo() {
        return to;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getSendgridAPIKey() {
        return sendgridAPIKey;
    }
    
    public void setSendgridAPIKey(String sendgridAPIKey) {
        this.sendgridAPIKey = sendgridAPIKey;
    }
}
