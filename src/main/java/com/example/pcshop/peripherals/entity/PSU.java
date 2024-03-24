package com.example.pcshop.peripherals.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PSU extends Product {
    @Column(nullable = false)
    private int brand;
    @Column(name = "power_output", nullable = false)
    private int powerOutput;
    @Column(name = "modular_type", nullable = false)
    private String modularType;
}
