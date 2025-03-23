package inatel.dm112.logistica.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Integer orderNumber;
    private String customerEmail;
    private boolean delivered;
    private String receiverCpf;
    private LocalDateTime deliveryDateTime;

    public Order() {
    }

    public Order(Integer orderNumber, String customerEmail) {
        this.orderNumber = orderNumber;
        this.customerEmail = customerEmail;
        this.delivered = false;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    @Override
    public String toString() {
        return "Order [orderNumber=" + orderNumber + ", customerEmail=" + customerEmail + ", delivered=" + delivered
                + ", receiverCpf=" + receiverCpf + ", deliveryDateTime=" + deliveryDateTime + "]";
    }
}