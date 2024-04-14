package com.example.pcshop.pc_components.service.impl;

import com.example.pcshop.category.Category;
import com.example.pcshop.pc_components.entity.Cpu;
import com.example.pcshop.pc_components.exceptions.AlreadyExists;
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
    public Optional<Cpu> saveCpu(Cpu cpu, long categoryId, String categoryName) {
        cpu.setCategory(Category.builder().id(categoryId).name(categoryName).build()); //spytać się Jarka czy git
        Optional<Cpu> savedCpu = cpuRepository.findByName(cpu.getName());
        Optional<Cpu> savedCpu1 = cpuRepository.findById(cpu.getId());
        if (savedCpu.isPresent())
            throw new AlreadyExists("Product already exists with given name: " +cpu.getName());
        else if (savedCpu1.isPresent()) {
            throw new AlreadyExists("Product already exists with given id: " +cpu.getId());
        }
        return Optional.of(cpuRepository.save(cpu));
    }

    @Override
    public List<Cpu> findAll() {
        return cpuRepository.findAll();
    }

    @Override
    public Optional<Cpu> findById(long id) {
        return cpuRepository.findById(id);
    }


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
