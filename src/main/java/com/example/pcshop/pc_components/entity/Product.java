package com.example.pcshop.pc_components.entity;

import com.example.pcshop.category.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")

public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @NotNull(message = "Produkt musi posiadać unikalną nazwę")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "name",nullable = false)
    private Category category;

    @NotNull(message = "Produkt musi posiadać cenę")
    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @NotNull(message = "Produkt musi posiadać producenta")
    @Column(name = "producer", nullable = false)
    private String producer;

    @NotNull(message = "Produkt musi posiadać liczbę produktów w magazynie")
    @Column(name = "amount_in_magazine", nullable = false)
    private int amountInMagazine;
//    @ManyToOne
//    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
//    private ShoppingCart shoppingCart;


}
