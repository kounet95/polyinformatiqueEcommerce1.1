package org.example.customercommands.service;

import org.example.customercommands.dto.CustomerEvent;
import org.example.customercommands.entity.Customers;
import org.example.customercommands.repos.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerCommandService {
@Autowired
    private CustomerInterface customerInterface;

    @Autowired
    private KafkaTemplate<String, CustomerEvent> kafkaTemplate;

  public Customers create(CustomerEvent customersEvent) {
      Customers customersDO = customerInterface.save(customersEvent.getCustomers());
      CustomerEvent event= new CustomerEvent ("CreateCustomer", customersDO);
      kafkaTemplate.send("Customer-event-topic", event);
      return customersDO;
  }

  public Customers update(CustomerEvent customersEvent, Long customerId) {
      Customers newCustomers = customersEvent.getCustomers();
       Customers existingCunstomer = customerInterface.findById(customerId).get();
      existingCunstomer.setAddress(newCustomers.getAddress());
      existingCunstomer.setEmail(newCustomers.getEmail());
      existingCunstomer.setFullName(newCustomers.getFullName());
      existingCunstomer.setCity(newCustomers.getCity());
      existingCunstomer.setCountry(newCustomers.getCountry());
      existingCunstomer.setId(customerId);
      existingCunstomer.setPassword(newCustomers.getPassword());
      existingCunstomer.setPhone(newCustomers.getPhone());
      existingCunstomer.setUsername(newCustomers.getUsername());
      existingCunstomer.setProfileImageUrl(newCustomers.getProfileImageUrl());
      existingCunstomer.setState(newCustomers.getState());

      Customers customersDO = customerInterface.save(existingCunstomer);
      CustomerEvent event=new CustomerEvent("UpdateCustomer", customersDO);
      kafkaTemplate.send("Customer-event-topic", event);
      return customersDO;

  }
}
