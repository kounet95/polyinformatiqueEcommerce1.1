package org.example.ecpolyquery.repos;

import org.example.ecpolyquery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}