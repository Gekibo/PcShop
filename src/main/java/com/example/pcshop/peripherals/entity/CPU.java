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
public class CPU extends Product {
    @Column(nullable = false)
    private int core;
    @Column(name = "base_frequency", nullable = false)
    private float baseFrequency;
}
