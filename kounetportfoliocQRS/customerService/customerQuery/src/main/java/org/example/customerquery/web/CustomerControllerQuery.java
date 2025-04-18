package org.example.customerquery.web;

import org.example.customerquery.entity.Customers;
import org.example.customerquery.service.CustomerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/query")
public class CustomerControllerQuery {
    @Autowired
    private CustomerQueryService customerQueryService;
   @GetMapping
    public List<Customers> findAll(){
        return customerQueryService.findAll();
    }
    @GetMapping("/{customerId}")
    public Customers findByCustomerId(@RequestParam Long customerId){
        return customerQueryService.findByCustomerId(customerId);
    }
}
