package com.example.pcshop.pc_components.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;


@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "rams")
public class RAM extends Product {
    @Column(nullable = false)
    private int size;
    private int ddr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RAM ram = (RAM) o;
        return size == ram.size && ddr == ram.ddr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, ddr);
    }
}
