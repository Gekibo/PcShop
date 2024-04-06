package com.example.pcshop.pc_components.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @NotNull(message = "Produkt musi posiadać unikalną nazwę")
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
//        @Column(name = "category_id", nullable = false)
//    private long categoryId;
    @NotNull(message = "Produkt musi posiadać cenę")
    @Column(nullable = false)
    private BigDecimal price;
    @NotNull(message = "Produkt musi posiadać producenta")
    @Column(nullable = false)
    private String producer;
    @NotNull(message = "Produkt musi posiadać liczbę produktów w magazynie")
    @Column(name = "amount_in_magazine", nullable = false)
    private int amountInMagazine;


}
