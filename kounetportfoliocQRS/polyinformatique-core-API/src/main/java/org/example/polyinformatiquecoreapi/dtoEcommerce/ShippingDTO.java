package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShippingDTO {
    private String id;
    private String orderId;
    private String deliveryStatus;
    private String estimatedDeliveryDate;
    private String shippingDate;
    private String shippingAddress;
}

