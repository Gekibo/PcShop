package com.example.pcshop.pc_components.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "cpus")
public class Cpu extends Product {
    @NotNull
    private int core;
    @NotNull
    private float baseFrequency;
}
