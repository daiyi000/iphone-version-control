package com.aeasy.iphoneversioncontrol.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_device")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_model", nullable = false)
    private String deviceModel;

    @Column(name = "supported_version")
    private String supportedVersion;
}
