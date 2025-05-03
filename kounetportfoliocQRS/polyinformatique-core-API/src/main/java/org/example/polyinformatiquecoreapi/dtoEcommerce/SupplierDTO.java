package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SupplierDTO {
    private String id;
    private String fullname;
    private String city;
    private String email;
    private String personToContact;
}

