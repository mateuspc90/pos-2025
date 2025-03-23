package inatel.dm112.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import inatel.dm112.logistica.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    @Query("SELECT o FROM Order o WHERE o.delivered = false")
    List<Order> findPendingDeliveries();
}