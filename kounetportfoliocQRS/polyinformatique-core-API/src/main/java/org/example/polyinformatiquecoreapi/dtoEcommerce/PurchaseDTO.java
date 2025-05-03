package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseDTO {
    private String id;
    private String supplierId;
    private String createdAt;
    private String status;
    private double total;
}

