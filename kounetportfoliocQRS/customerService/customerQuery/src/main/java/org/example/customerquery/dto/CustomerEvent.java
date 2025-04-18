package org.example.customerquery.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.customerquery.entity.Customers;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEvent {

    private String eventType;

    private Customers customers;
}
