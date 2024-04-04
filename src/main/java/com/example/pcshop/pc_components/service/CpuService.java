package com.example.pcshop.pc_components.service;

import com.example.pcshop.pc_components.entity.Cpu;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CpuService {
    Cpu save(Cpu cpu);

    List<Cpu> findAll();

    Optional<Cpu> findById(long id);

//    Cpu updateCpu(Cpu updatedCpu);
    Optional<Cpu> updateCpu(long id, Cpu updatedCpu);

    void deleteById(long cpuId);
}
