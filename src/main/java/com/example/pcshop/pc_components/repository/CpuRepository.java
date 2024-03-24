package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.CPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CpuRepository extends JpaRepository<CPU,Long> {

    Optional<CPU> findByName(String name);

    List<CPU> findByCategoryId(long categoryId);

    List<CPU> findAllByPrice(BigDecimal price);

    List<CPU> findAllByProducer(String producer);

//    List<CPU> findAllByAmountInMagazine(long amountInMagazine);
//
//    List<CPU> findAllByAvailableIsTrue(long amountInMagazine);
@Query(value = "SELECT * FROM cpus c WHERE c.amount_in_magazine > 0", nativeQuery = true)
    List<CPU> findAllByAmountInMagazineGreaterThan0();
//List<CPU> findAllByAmountInMagazineIsGreaterThan();

//    List<CPU> findAllByCores(int cores);
}
