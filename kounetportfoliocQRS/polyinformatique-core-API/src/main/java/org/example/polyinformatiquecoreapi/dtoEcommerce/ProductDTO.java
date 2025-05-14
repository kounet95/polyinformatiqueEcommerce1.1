package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private String createdAt;
    private String closedAt;
    private String subcategoryId;
    private String socialGroupId;
    private String imageUrl;
    private boolean isActive;
}
