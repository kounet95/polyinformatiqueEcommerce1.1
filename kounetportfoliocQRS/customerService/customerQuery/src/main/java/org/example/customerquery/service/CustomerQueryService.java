package org.example.customerquery.service;

import org.example.customerquery.dto.CustomerEvent;
import org.example.customerquery.entity.Customers;
import org.example.customerquery.repos.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerQueryService {
    @Autowired
    private CustomerInterface customerInterface;

    public List<Customers> findAll() {
        return customerInterface.findAll();

    }

    public Customers findByCustomerId(Long customerId) {
            return customerInterface.findById(customerId).get();
    }


    @KafkaListener(topics = "Customer-event-topic",groupId = "Customer-event-group")
    public void processCustomerEvents(CustomerEvent customerEvent) {
        Customers customers = customerEvent.getCustomers();

        if (customerEvent.getEventType().equals("CreateCustomer")) {
            customerInterface.save(customers);
        }
        if (customerEvent.getEventType().equals("UpdateCustomer")) {
            Customers existingCustomer = customerInterface.findById(customers.getId()).get();
            existingCustomer.setAddress(customers.getAddress());
            existingCustomer.setEmail(customers.getEmail());
            existingCustomer.setFullName(customers.getFullName());
            existingCustomer.setCity(customers.getCity());
            existingCustomer.setCountry(customers.getCountry());
            existingCustomer.setId(customers.getId());
            existingCustomer.setPassword(customers.getPassword());
            existingCustomer.setPhone(customers.getPhone());
            existingCustomer.setUsername(customers.getUsername());
            existingCustomer.setProfileImageUrl(customers.getProfileImageUrl());
            existingCustomer.setState(customers.getState());

            customerInterface.save(existingCustomer);
        }
    }
}

