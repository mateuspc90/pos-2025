package inatel.dm112.logistica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inatel.dm112.logistica.model.DeliveryRegistrationDTO;
import inatel.dm112.logistica.model.Order;
import inatel.dm112.logistica.service.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryRestController {

    @Autowired
    private DeliveryService deliveryService;
    
    @GetMapping("")  // Mostra todos os pedidos na lista de entregas
    public ResponseEntity<List<Order>> getAllDeliveries() {
        List<Order> allDeliveries = deliveryService.getAllDeliveries();
        return new ResponseEntity<>(allDeliveries, HttpStatus.OK);
    }

    @GetMapping("/pending") // Mostra todos os pedidos pendentes de entrega
    public ResponseEntity<List<Order>> getPendingDeliveries() {
        List<Order> pendingDeliveries = deliveryService.getPendingDeliveries();
        return new ResponseEntity<>(pendingDeliveries, HttpStatus.OK);
    }
    
    @PostMapping("/register") // Registra a entrega de um pedido
    public ResponseEntity<Order> registerDelivery(@RequestBody DeliveryRegistrationDTO deliveryData) {
        Order deliveredOrder = deliveryService.registerDelivery(deliveryData);
        return new ResponseEntity<>(deliveredOrder, HttpStatus.OK);
    }
}
