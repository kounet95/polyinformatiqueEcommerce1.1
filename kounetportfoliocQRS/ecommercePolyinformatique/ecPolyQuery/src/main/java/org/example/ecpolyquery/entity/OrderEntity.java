package org.example.ecpolyquery.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private LocalDateTime createdAt;
    private String orderStatus;
    private String paymentMethod;
    private double total;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> lines;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Invoice invoice;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Shipping shipping;
}

