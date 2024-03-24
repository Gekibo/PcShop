package com.example.pcshop.peripherals.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "caregories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
//    @JoinTable()
//    @ManyToMany()
//    private List<Peripheral> listOfPeripherals;
}
