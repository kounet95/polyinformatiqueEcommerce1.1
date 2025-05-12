package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseItemDTO {
    private String id;
    private String purchaseId;
    private String productId;
    private int qty;
    private double unitPrice;
}

