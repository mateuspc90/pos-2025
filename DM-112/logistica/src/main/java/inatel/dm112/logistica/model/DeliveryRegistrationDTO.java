package inatel.dm112.logistica.model;

public class DeliveryRegistrationDTO {
    
    private Integer orderNumber;
    private String receiverCpf;
    
    public DeliveryRegistrationDTO() {
    }
    
    public DeliveryRegistrationDTO(Integer orderNumber, String receiverCpf) {
        this.orderNumber = orderNumber;
        this.receiverCpf = receiverCpf;
    }
    
    public Integer getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public String getReceiverCpf() {
        return receiverCpf;
    }
    
    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }
}