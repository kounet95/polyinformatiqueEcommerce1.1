package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDTO {
    private String id;
    private String customerId;
    private String createdAt;
    private String orderStatus;
    private String paymentMethod;
    private double total;
    private String barcode;
}
