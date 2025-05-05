package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StockDTO {
    private String id;
    private String productSizeId;
    private String supplierId;
    private double purchasePrice;
    private double promoPrice;
    private double salePrice;
    private int stockAvailable;
    private double quantity;
}

