package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String shippingAddress;
    private String billingAddress;
}

