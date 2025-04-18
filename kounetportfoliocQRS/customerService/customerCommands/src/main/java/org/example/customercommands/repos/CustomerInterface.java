package org.example.customercommands.repos;

import org.example.customercommands.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInterface extends JpaRepository<Customers,Long> {
}
