package com.programmingtechie.orderService.repository;

import com.programmingtechie.orderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,String> {
}
