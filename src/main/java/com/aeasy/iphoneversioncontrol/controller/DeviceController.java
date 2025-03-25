package com.aeasy.iphoneversioncontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeasy.iphoneversioncontrol.model.Device;
import com.aeasy.iphoneversioncontrol.service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/list")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping("/add")
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }
}
