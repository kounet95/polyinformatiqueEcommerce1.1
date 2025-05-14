package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusDTO {
    private String id;
    private String orderId;
    private String barcode;
    private String status;
    private String updatedAt;
    private String customerId;
    private String customerName;
}