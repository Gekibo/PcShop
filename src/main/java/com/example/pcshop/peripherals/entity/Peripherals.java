package com.example.pcshop.peripherals.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "peripherals")
public class Peripherals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "cpu_id")
    private CPU cpuId;
    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private GPU gpuId;
    @ManyToOne
    @JoinColumn(name = "motherboard_id")
    private Motherboard motherboardId;
    @ManyToOne
    @JoinColumn(name = "ram_id")
    private RAM ramId;
    @ManyToOne
    @JoinColumn(name = "psu_id")
    private PSU psuId;
    @ManyToOne
    @JoinColumn(name = "hard_disk_id")
    private HardDisk hardDiskId;
}
