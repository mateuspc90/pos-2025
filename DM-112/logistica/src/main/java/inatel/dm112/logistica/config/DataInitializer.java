package inatel.dm112.logistica.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import inatel.dm112.logistica.model.Order;
import inatel.dm112.logistica.repository.OrderRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Adiciona alguns pedidos de exemplo
        orderRepository.save(new Order(1001, "mateuspc90@hotmail.com"));
        orderRepository.save(new Order(1002, "cliente2@example.com"));
        orderRepository.save(new Order(1003, "cliente3@example.com"));
        
        System.out.println("Dados de exemplo inseridos com sucesso!");
    }
}