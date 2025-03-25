package com.aeasy.iphoneversioncontrol.repository;

import com.aeasy.iphoneversioncontrol.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceModel(String model);
}
