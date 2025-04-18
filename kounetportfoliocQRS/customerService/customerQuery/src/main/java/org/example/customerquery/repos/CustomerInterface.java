package org.example.customerquery.repos;

import org.example.customerquery.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInterface extends JpaRepository<Customers,Long> {
}
