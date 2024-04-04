package com.example.pcshop.pc_components.service.impl;

import com.example.pcshop.pc_components.entity.Cpu;
import com.example.pcshop.pc_components.exceptions.ProductAlreadyExists;
import com.example.pcshop.pc_components.repository.CpuRepository;
import com.example.pcshop.pc_components.service.CpuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CpuServiceImpl implements CpuService {
    private final CpuRepository cpuRepository;

    public CpuServiceImpl(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @Override
    public Cpu save(Cpu cpu) {
        Optional<Cpu> savedCpu = cpuRepository.findByName(cpu.getName());
        if (savedCpu.isPresent())
            throw new ProductAlreadyExists("Product already exists with given name: " +cpu.getName());
        return cpuRepository.save(cpu);
    }

    @Override
    public List<Cpu> findAll() {
        return cpuRepository.findAll();
    }

    @Override
    public Optional<Cpu> findById(long id) {
        return cpuRepository.findById(id);
    }

//    @Override
//    public Cpu updateCpu(Cpu updatedCpu) {
//        return cpuRepository.save(updatedCpu);
//    }

    @Override
    public Optional<Cpu> updateCpu(long id, Cpu updatedCpu) {
        return findById(id)
                .map(savedCpu ->{
                    savedCpu.setName(updatedCpu.getName());
                    savedCpu.setDescription(updatedCpu.getDescription());
                    savedCpu.setPrice(updatedCpu.getPrice());
                    savedCpu.setProducer(updatedCpu.getProducer());
                    savedCpu.setAmountInMagazine(updatedCpu.getAmountInMagazine());
                    savedCpu.setCore(updatedCpu.getCore());
                    savedCpu.setBaseFrequency(updatedCpu.getBaseFrequency());
                    return cpuRepository.save(savedCpu);
                });
    }

    @Override
    public void deleteById(long cpuId) {
        cpuRepository.deleteById(cpuId);

    }
}
