package com.example.pcshop.peripherals.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
// to jest klasa HardDisk Andrzeja
public class HardDisk extends Product {
    @Column(name = "memory_type", nullable = false)
    private String memoryType;
    @Column(name = "disc_capacity", nullable = false)
    private int diskCapacity;
}
