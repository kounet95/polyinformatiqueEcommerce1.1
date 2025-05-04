package org.example.ecpolyquery.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Shipping {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String deliveryStatus;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime shippingDate;
    private String shippingAddress;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

