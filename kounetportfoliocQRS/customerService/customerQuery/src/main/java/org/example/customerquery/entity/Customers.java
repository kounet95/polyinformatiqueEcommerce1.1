package org.example.customerquery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "Query")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String profileImageUrl;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String username;
    private String password;
}
