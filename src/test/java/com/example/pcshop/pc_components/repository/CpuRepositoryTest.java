package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.CPU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CpuRepositoryTest {
    @Autowired
    private CpuRepository cpuRepository;
    private CPU cpu;
    @BeforeEach
    void setUp(){
        cpu = CPU.builder()
                .id(1)
                .name("i5-7500k")
                .description("coś ")
                .categoryId(1)
                .price(BigDecimal.valueOf(200))
                .producer("Intel")
                .amountInMagazine(10)
                .core(4)
                .baseFrequency(3.0f)
                .build();
    }
    @Test
    @DisplayName("Zapisywanie CPU")
    void savingCPU(){
        //given
        //when
        CPU savedCPU = cpuRepository.save(cpu);

        //then
        assertThat(savedCPU).isNotNull();
        assertThat(savedCPU.getId()).isGreaterThan(0);
        assertThat(savedCPU).isEqualTo(cpu);
    }


}