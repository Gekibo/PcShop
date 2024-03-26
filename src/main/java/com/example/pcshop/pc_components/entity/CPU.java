package com.example.pcshop.pc_components.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CPU extends Product {
//    @Column(nullable = false)
    @NotNull
    private int core;
//    @Column(name = "base_frequency", nullable = false)
    @NotNull
    private float baseFrequency;
}
