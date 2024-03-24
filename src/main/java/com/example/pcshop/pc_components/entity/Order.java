package com.example.pcshop.pc_components.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Column(name = "product_id", nullable = false)
    private long productId;
    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;
    @Column(name = "total_value", nullable = false)
    private BigDecimal totalValue;
    @Column(name = "date_of_order", nullable = false)
    private LocalDate dateOfOrder;
    @Column(nullable = false)
    private String status;
}
