package org.example.customercommands.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.customercommands.entity.Customers;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEvent {

    private String eventType;
    private Customers customers;
}
