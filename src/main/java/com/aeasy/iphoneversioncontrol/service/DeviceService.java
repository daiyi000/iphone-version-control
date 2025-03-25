package com.aeasy.iphoneversioncontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeasy.iphoneversioncontrol.model.Device;
import com.aeasy.iphoneversioncontrol.repository.DeviceRepository;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }
}
