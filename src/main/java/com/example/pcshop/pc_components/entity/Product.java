package com.example.pcshop.pc_components.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "products")
public abstract class Product {
//    @Builder.Default
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @Column(name = "category_id", nullable = false)
    private long categoryId;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String producer;
    @Column(name = "amount_in_magazine", nullable = false)
    private int amountInMagazine;
}
