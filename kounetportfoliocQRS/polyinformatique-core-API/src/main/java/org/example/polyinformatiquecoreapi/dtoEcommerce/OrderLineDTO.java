package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderLineDTO {
    private String id;
    private String orderId;
    private String productSizeId;
    private int qty;
}

