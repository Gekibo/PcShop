package com.example.pcshop.pc_components.service;

import com.example.pcshop.pc_components.entity.Cpu;

import java.util.List;
import java.util.Optional;

public interface CpuService {
    Optional<Cpu> saveCpu(Cpu cpu, long categoryId, String categoryName);

    List<Cpu> findAll();

    Optional<Cpu> findById(long id);


    Optional<Cpu> updateCpu(long id, Cpu updatedCpu);

    void deleteById(long cpuId);
}
