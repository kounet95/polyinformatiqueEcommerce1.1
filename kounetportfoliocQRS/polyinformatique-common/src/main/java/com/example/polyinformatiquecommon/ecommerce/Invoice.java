package com.example.polyinformatiquecommon.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "common_ecommerce_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Invoice {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private double amount;
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orderecommerce orderecommerce;
}
