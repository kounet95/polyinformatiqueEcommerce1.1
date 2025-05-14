package org.example.ecpolyquery.repos;
import com.example.polyinformatiquecommon.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}