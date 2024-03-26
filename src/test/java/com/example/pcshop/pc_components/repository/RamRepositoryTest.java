package com.example.pcshop.pc_components.repository;

import com.example.pcshop.pc_components.entity.RAM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class RamRepositoryTest {
    @Autowired
    private RamRepository ramRepository;
    private RAM ram;
private final String name = "ram name";
    @BeforeEach
    void setUp() {
        ram = RAM.builder()
//                .id(1)
                .name(name)
                .description("description")
                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("producer's name")
                .amountInMagazine(3)
                .size(8)
                .ddr(1)
                .build();

    }
    @AfterEach
    void tearDown() {
        ramRepository.deleteAll();
    }

    @DisplayName("zapisywanie ram")
    @Test
    void shouldReturnRam() {
//        given
//        when
        RAM savedRam = ramRepository.save(ram);
//        then
        assertThat(savedRam).isNotNull();
        assertThat(savedRam).isEqualTo(ram);
        assertThat(savedRam.getId()).isGreaterThan(0);
    }
    @DisplayName("zapisywanie ram z taką samą nazwą")
    @Test
    void shouldThrowExceptionWhenTheSameName() {
//        given
        RAM ram2 = ram = RAM.builder()
//                .id(2)
                .name(name)
                .description("description")
                .categoryId(1)
                .price(BigDecimal.valueOf(300))
                .producer("producer's name")
                .amountInMagazine(3)
                .size(8)
                .ddr(1)
                .build();
//        when
        ramRepository.save(ram);
//        then
        assertThrows(DataIntegrityViolationException.class, () -> {
            ramRepository.save(ram2);
        });

    }

    @DisplayName("testowanie usuwania po id")
    @Test
    void shouldDeleteRamById() {
//        given
        RAM savedRam = ramRepository.save(ram);
//        when
        ramRepository.deleteById(ram.getId());
        Optional<RAM> byId = ramRepository.findById(ram.getId());
//        then
        assertThat(byId).isEmpty();
    }
    @DisplayName("wyszukiwanie po id- happy path")
    @Test
    void shouldReturnRamByIf() {
//        given
        ramRepository.save(ram);
//        when
        Optional<RAM> byId = ramRepository.findById(ram.getId());
//        then
        assertThat(byId).isNotNull();
        assertThat(byId.get()).isEqualTo(ram);
    }
    @DisplayName("wyszukiwanie po id kiedy nie ma obiektu z danym id")
    @Test
    void shouldReturnEmptyById() {
//        given
//        when
        Optional<RAM> byId = ramRepository.findById(ram.getId());
//        then
        assertThat(byId).isEmpty();
    }

    @DisplayName("Edytowanie obiektu")
    @Test
    void shouldReturnUpdatedRam() {
//        given
        RAM savedRam = ramRepository.save(ram);
        savedRam.setDescription("inny opis");
//        when
        RAM updatedRam = ramRepository.save(savedRam);
//        then
        assertThat(updatedRam).isNotNull();
        assertThat(updatedRam).isEqualTo(savedRam);
        }
    @DisplayName("Wyszukiwanie wszystkich produktów")
    @Test
    void shouldReturnListOfAllRam() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams = ramRepository.findAll();
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("wyszukiwanie produktów po kategorii")
    @Test
    void shouldReturnListOfRamByCategory() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams = ramRepository.findByCategoryId(ram.getCategoryId());
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("wyszukiwanie produktów po kategorii jeśli nie ma takich produktów")
    @Test
    void shouldReturnEmptyListOfRamByCategory() {
//        given
//        when
        List<RAM> rams = ramRepository.findByCategoryId(ram.getCategoryId());
//        then
        assertThat(rams).isEmpty();
    }

    @DisplayName("Wyszukiwanie produktu po nazwie")
    @Test
    void shouldReturnRamByName() {
//        given
        ramRepository.save(ram);
//        when
        Optional<RAM> byName = ramRepository.findByName(ram.getName());
//        then
        assertThat(byName).isNotNull();
        assertThat(byName.get()).isEqualTo(ram);
    }
    @DisplayName("powbieranie produktu po nazwie jeśli nie ma takiego produktu")
    @Test
    void shouldReturnEmptyByName() {
//        given
//        when
        Optional<RAM> byName = ramRepository.findByName(ram.getName());
//        then
        assertThat(byName).isEmpty();
    }
    @DisplayName("Wyszukiwanie produktu po cenie")
    @Test
    void shouldReturnRamByPrice() {
//        given
        ramRepository.save(ram);
//        when
       List<RAM> rams = ramRepository.findByPrice(ram.getPrice());
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("Wyszukiwanie produktów po cenie jeśli takich nie ma")
    @Test
    void shouldReturnEmptyListOfRamByPrice() {
//        given
//        when
        List<RAM> rams = ramRepository.findByPrice(ram.getPrice());
//        then
        assertThat(rams).isEmpty();
    }
    @DisplayName("Wyszukiwanie produktów po producencie")
    @Test
    void shouldReturnListOfRamByProducer() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams = ramRepository.findByProducer(ram.getProducer());
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("Wyszukiwanie produktów po producencie jeśli takich nie ma")
    @Test
    void shouldReturnEmptyListByProducer() {
//        given
//        when
        List<RAM> rams = ramRepository.findByProducer(ram.getProducer());
//        then
        assertThat(rams).isEmpty();
    }
    @DisplayName("Wyszukiwanie produktów po rozmiarze")
    @Test
    void shouldReturnListOfRamBySize() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams = ramRepository.findBySize(ram.getSize());
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("Wyszukiwanie produktów po rozmiarze jeśli takich nie ma")
    @Test
    void shouldReturnEmptyListBySize() {
//        given
//        when
        List<RAM> rams = ramRepository.findBySize(ram.getSize());
//        then
        assertThat(rams).isEmpty();
    }
    @DisplayName("Wyszukiwanie produktów po ddr")
    @Test
    void shouldReturnListOfRamByDdr() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams = ramRepository.findByDdr(ram.getDdr());
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
    @DisplayName("Wyszukiwanie produktów po ddr jeśli takich nie ma")
    @Test
    void shouldReturnEmptyListByDdr() {
//        given
//        when
        List<RAM> rams = ramRepository.findByDdr(ram.getDdr());
//        then
        assertThat(rams).isEmpty();
    }
    @DisplayName("Wyszukiwanie wszystkich dostępnych produktów")
    @Test
    void shouldReturnListOfRamByAvailable() {
//        given
        ramRepository.save(ram);
//        when
        List<RAM> rams  = ramRepository.findByAvailableIsTrue();
//        then
        assertThat(rams).isNotEmpty();
        assertThat(rams.size()).isEqualTo(1);
        assertThat(rams.get(0)).isEqualTo(ram);
    }
}




















