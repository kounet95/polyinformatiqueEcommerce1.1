package org.example.customercommon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEvent implements Serializable {

    private String eventType;
    private Customers customers;
}
