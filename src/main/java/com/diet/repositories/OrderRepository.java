package com.diet.repositories;

import com.diet.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OrderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {

}
