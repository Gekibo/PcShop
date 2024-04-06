package com.example.pcshop.pc_components.controller;

import com.example.pcshop.pc_components.entity.Cpu;
import com.example.pcshop.pc_components.service.CpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpus")
public class CpuController {
    private final CpuService cpuService;

    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cpu createCpu(@RequestBody Cpu cpu){
        return cpuService.save(cpu);
    }
    @GetMapping
    public List<Cpu> getCpus(){
        return cpuService.findAll();
    }
    @Operation(summary = "Get a procesor by id", description = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
    @GetMapping(value = "/{id}", name = "Wyszukaj procesor po ID")

    public ResponseEntity<Cpu> getCpuById(@PathVariable long id){
        return cpuService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @PutMapping("{id}")
    public ResponseEntity<Cpu> updateCpu(@PathVariable long id, @RequestBody Cpu cpu){
        return cpuService.updateCpu(id, cpu)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCpu(@PathVariable("id") long cpuId){
        cpuService.deleteById(cpuId);
        return new ResponseEntity<>("Cpu deleted successfully", HttpStatus.OK);
    }
}
