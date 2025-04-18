package org.example.customercommands.web;

import org.example.customercommands.dto.CustomerEvent;
import org.example.customercommands.entity.Customers;
import org.example.customercommands.service.CustomerCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CustomersCommand")
public class CustomerController {
   @Autowired
    CustomerCommandService customerCommandService;
 @PostMapping
    public Customers createCustomer(@RequestBody CustomerEvent customer) {
        return customerCommandService.create(customer);
    }
 @PutMapping("/{customerId}")
    public Customers update(@RequestBody CustomerEvent customer, @PathVariable Long customerId) {
        return customerCommandService.update(customer, customerId);
    }
 }
