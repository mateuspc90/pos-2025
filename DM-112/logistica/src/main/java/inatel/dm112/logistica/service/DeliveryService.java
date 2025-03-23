package inatel.dm112.logistica.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inatel.dm112.logistica.model.DeliveryRegistrationDTO;
import inatel.dm112.logistica.model.MailRequestData;
import inatel.dm112.logistica.model.Order;
import inatel.dm112.logistica.repository.OrderRepository;
import inatel.dm112.logistica.rest.support.UtilityException;

@Service
public class DeliveryService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private EmailContentGenerator emailContentGenerator;
    
    public List<Order> getAllDeliveries() {
        return orderRepository.findAll(); 
    }

    public List<Order> getPendingDeliveries() {
        return orderRepository.findPendingDeliveries();
    }
    
    public Order registerDelivery(DeliveryRegistrationDTO deliveryData) {
        Integer orderNumber = deliveryData.getOrderNumber();
        Optional<Order> optOrder = orderRepository.findById(orderNumber);
        
        if (!optOrder.isPresent()) {
            throw new UtilityException("Pedido " + orderNumber + " não encontrado.");
        }
        
        Order order = optOrder.get();
        
        if (order.isDelivered()) {
            throw new UtilityException("Pedido " + orderNumber + " já foi entregue.");
        }
        
        // Registra a entrega
        order.setDelivered(true);
        order.setReceiverCpf(deliveryData.getReceiverCpf());
        order.setDeliveryDateTime(LocalDateTime.now());
        
        // Salva a atualização no banco
        Order savedOrder = orderRepository.save(order);
        
        // Gera e envia o e-mail de confirmação
        sendDeliveryConfirmationEmail(savedOrder);
        
        return savedOrder;
    }
    
    private void sendDeliveryConfirmationEmail(Order order) {
        try {
            // Gera o conteúdo do e-mail (PDF ou HTML)
            String emailContent = emailContentGenerator.generateDeliveryConfirmationContent(order);
            
            // Prepara os dados para o serviço de e-mail
            MailRequestData mailReq = new MailRequestData(
                order.getOrderNumber(),
                order.getCustomerEmail(),
                emailContent
            );
            
            // Envia o e-mail
            mailService.sendMail(mailReq);
        } catch (Exception e) {
            // Loga o erro, mas não impede o registro da entrega
            System.err.println("Erro ao enviar e-mail de confirmação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
