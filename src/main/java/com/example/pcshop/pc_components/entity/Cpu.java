package com.example.pcshop.pc_components.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;



@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "cpus")
//@PrimaryKeyJoinColumn(name = "id")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)

public class Cpu extends Product {

    @NotNull(message = "Produkt musi posiadać liczbę rdzeni")
    @Column(nullable = false)
    private int core;
    @NotNull(message = "Produkt musi posiadać taktowanie procesora")
    @Column(nullable = false)
    private float baseFrequency;

}