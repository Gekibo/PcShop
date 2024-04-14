package com.example.pcshop.pc_components.controller;

import com.example.pcshop.pc_components.entity.Cpu;
import com.example.pcshop.pc_components.exceptions.AlreadyExists;
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

    @Operation(summary = "Create new processor", description = "Creates new processor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request - The request was invalid")
    })
    @PostMapping
    @ResponseBody()
    public ResponseEntity<?> createCpu(@RequestBody Cpu cpu, long categoryId, String categoryName){
        try {
            return ResponseEntity.ok(cpuService.saveCpu(cpu, categoryId, categoryName)
                    .orElseThrow());
        }catch (AlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        //        return cpuService.saveCpu(cpu)
//                .map(ResponseEntity::ok)
//                .orElseGet(()->ResponseEntity.notFound().build()).getBody();
    }

    @Operation(summary = "Get all processors", description = "Returns all processors as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The products was not found")
    })
    @GetMapping
    public List<Cpu> getCpus(){
        return cpuService.findAll();
    }

    @Operation(summary = "Get a processor by id", description = "Returns a processor as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The processor was not found")
    })
    @GetMapping(value = "/{id}")

    public ResponseEntity<Cpu> getCpuById(@PathVariable long id){
        return cpuService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
    @Operation(summary = "Update processor by id", description = "Updates a processor as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Not found - The processor was not found")
    })
    @PutMapping("{id}")
    public ResponseEntity<Cpu> updateCpu(@PathVariable long id, @RequestBody Cpu cpu){
        return cpuService.updateCpu(id, cpu)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete CPU by id", description = "Deletes a CPU by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Not found - The processor was not found")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCpu(@PathVariable("id") long cpuId){
        cpuService.deleteById(cpuId);
        return new ResponseEntity<>("Cpu deleted successfully", HttpStatus.OK);
    }
}
