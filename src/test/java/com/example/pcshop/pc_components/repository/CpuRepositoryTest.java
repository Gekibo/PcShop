package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.Cpu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CpuRepositoryTest {
    @Autowired
    private CpuRepository cpuRepository;
    private Cpu cpu;
    @BeforeEach
    void setUp(){
        cpu = Cpu.builder()
//                .id(1)
                .name("i5-7500k")
                .description("coś Intel")
//                .categoryId(1)
                .price(BigDecimal.valueOf(200))
                .producer("Intel")
                .amountInMagazine(10)
                .core(4)
                .baseFrequency(3.0f)
                .build();
    }
    @Test
    @DisplayName("Zapisywanie CPU")
    void savingCPU() {
        //given
        //when
        Cpu savedCpu = cpuRepository.save(cpu);

        //then
        assertThat(savedCpu).isNotNull();
        assertThat(savedCpu.getId()).isGreaterThan(0);
        assertThat(savedCpu).isEqualTo(cpu);
    }
    @Test
    @DisplayName("Usuwanie CPU")
    void deleteCPU(){
        //given
        cpuRepository.save(cpu);
        //when
        cpuRepository.deleteById(cpu.getId());
        Optional<Cpu> cpuOptional = cpuRepository.findById(cpu.getId());
        //then
        assertThat(cpuOptional).isEmpty();

    }

    @Test
    @DisplayName("Pobieranie wszystkich CPU")
    void findAllCpu() {
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("AMD")
                .amountInMagazine(5)
                .core(8)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList = cpuRepository.findAll();

        //then
        assertThat(cpuList).isNotNull();
        assertThat(cpuList.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("Pobieranie CPU po id")
    void findCPUbyId(){
        //given
        cpuRepository.save(cpu);
        //when
        Cpu cpuById = cpuRepository.findById(cpu.getId()).get();
        //then
        assertThat(cpuById).isNotNull();
        assertThat(cpuById).isEqualTo(cpu);
    }
    @Test
    @DisplayName("Pobieranie CPU po nazwie")
    void findCPUbyName(){
        //given
        cpuRepository.save(cpu);
        //when
        Cpu cpuByName = cpuRepository.findByName(cpu.getName()).get();
        //then
        assertThat(cpuByName).isNotNull();
        assertThat(cpuByName).isEqualTo(cpu);
    }
//    @Test
//    @DisplayName("Pobieranie wszystkich CPU po kategorii")
//    void findCpuByCategory(){
//        //given
//        CPU cpu1 = CPU.builder()
//                .id(2)
//                .name("5600")
//                .description("coś AMD ")
////                .categoryId(1)
//                .price(BigDecimal.valueOf(300))
//                .producer("AMD")
//                .amountInMagazine(5)
//                .core(8)
//                .baseFrequency(3.2f)
//                .build();
//        cpuRepository.save(cpu);
//        cpuRepository.save(cpu1);
//        //when
//        List<CPU> cpuList = cpuRepository.findByCategoryId(1);
//        //then
//        assertThat(cpuList).isNotNull();
//        assertThat(cpuList.size()).isEqualTo(2);
//    }
    @Test
    @DisplayName("Pobieranie wszystkich CPU po cenie")
    void findAllCPUbyPrice(){
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(200))
                .producer("AMD")
                .amountInMagazine(5)
                .core(8)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList = cpuRepository.findAllByPrice(BigDecimal.valueOf(200));
        //then
        assertThat(cpuList).isNotNull();
        assertThat(cpuList.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("Pobieranie wszystkich CPU po producencie")
    void findAllCPUbyProducer(){
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("Intel")
                .amountInMagazine(5)
                .core(4)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList =cpuRepository.findAllByProducer("Intel");
        //then
        assertThat(cpuList).isNotNull().isNotEmpty();
        assertThat(cpuList.size()).isEqualTo(2);

    }
    @Test
    @DisplayName("Pobieranie wszystkich CPU dostępnych w magazynie")
    void findAllCPUbyAmountInMagazine() {
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("AMD")
                .amountInMagazine(5)
                .core(8)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList = cpuRepository.findAllByAmountInMagazineGreaterThan0();
        //then
        assertThat(cpuList).isNotNull();
        assertThat(cpuList.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("Pobieranie wszystkich CPU po ilości rdzeni")
    void findAllCPUbyCores() {
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("AMD")
                .amountInMagazine(10)
                .core(4)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList = cpuRepository.findAllByCore(4);
        //then
        assertThat(cpuList).isNotNull();
        assertThat(cpuList.size()).isEqualTo(2);
    }
    @Test
    @DisplayName("Pobieranie wszystkich CPU po ilości rdzeni")
    void findAllCpuByBaseFrequency() {
        //given
        Cpu cpu1 = Cpu.builder()
                .id(2)
                .name("5600")
                .description("coś AMD ")
//                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("AMD")
                .amountInMagazine(10)
                .core(4)
                .baseFrequency(3.2f)
                .build();
        cpuRepository.save(cpu);
        cpuRepository.save(cpu1);
        //when
        List<Cpu> cpuList = cpuRepository.findAllByBaseFrequencyGreaterThanEqual(3.0f);
        //then
        assertThat(cpuList).isNotNull();
        assertThat(cpuList.size()).isEqualTo(2);
    }
    // TODO
    // testy z 2 cpu z tymi samymi nazwami



}