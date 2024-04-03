package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CpuRepository extends JpaRepository<Cpu,Long> {

    Optional<Cpu> findByName(String name);

//    List<CPU> findByCategoryId(long categoryId);

    List<Cpu> findAllByPrice(BigDecimal price);

    List<Cpu> findAllByProducer(String producer);


@Query(value = "SELECT c FROM Cpu c INNER JOIN Product p ON p.id = c.id WHERE p.amountInMagazine > 0")
    List<Cpu> findAllByAmountInMagazineGreaterThan0();

    List<Cpu> findAllByPriceAndProducer(BigDecimal price, String producer);

    List<Cpu> findAllByCore(int cores);


    List<Cpu> findAllByBaseFrequencyGreaterThanEqual(float baseFrequency);
}
