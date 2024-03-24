package com.example.pcshop.peripherals.repository;


import com.example.pcshop.peripherals.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
