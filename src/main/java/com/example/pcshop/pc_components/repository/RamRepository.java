package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RamRepository extends JpaRepository<RAM, Long> {
    Optional<RAM> findByName(String name);

    List<RAM> findByCategoryId(long categoryId);

    List<RAM> findByPrice(BigDecimal price);
    List<RAM> findByProducer(String producer);
    List<RAM> findBySize(int size);
    List<RAM> findByDdr(int ddr);
@Query(value = "SELECT * FROM rams WHERE amount_in_magazine > 0", nativeQuery = true)
    List<RAM> findByAvailableIsTrue();
}
