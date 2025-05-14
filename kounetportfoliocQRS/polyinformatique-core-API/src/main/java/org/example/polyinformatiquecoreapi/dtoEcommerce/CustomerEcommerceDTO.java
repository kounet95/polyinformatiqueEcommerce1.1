package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CustomerEcommerceDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String shippingAddress;
    private String billingAddress;
    private LocalDateTime createdAt;
}

