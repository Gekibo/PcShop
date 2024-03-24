package com.example.pcshop.pc_components.repository;


import com.example.pcshop.pc_components.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
