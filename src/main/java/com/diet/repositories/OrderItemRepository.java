package com.diet.repositories;

import com.diet.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OrderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
