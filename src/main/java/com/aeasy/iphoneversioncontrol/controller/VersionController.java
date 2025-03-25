package com.aeasy.iphoneversioncontrol.controller;

import org.springframework.data.domain.Page;
import com.aeasy.iphoneversioncontrol.model.Version;
import com.aeasy.iphoneversioncontrol.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/version")
public class VersionController {
    @Autowired
    private VersionService versionService;

    @GetMapping("/list")
    public ResponseEntity<Page<Version>> getVersionsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(versionService.getVersionsByPage(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addVersion(@RequestBody Version version) {
        System.out.println("Received Version: " + version);
        // 修改点：返回保存后的 Version 对象，包含生成的 id
        Version savedVersion = versionService.addVersion(version);
        return ResponseEntity.ok(savedVersion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVersionById(@PathVariable Long id) {
        Optional<Version> version = versionService.getVersionById(id);
        return version.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVersion(@PathVariable Long id) {
        versionService.deleteVersion(id);
        return ResponseEntity.ok("Version deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVersion(@PathVariable Long id, @RequestBody Version updatedVersion) {
        Version version = versionService.updateVersion(id, updatedVersion);
        return ResponseEntity.ok(version);
    }
    
    @GetMapping("/search")
    public ResponseEntity<Page<Version>> searchVersions(
            @RequestParam("iosVersion") String iosVersion,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(versionService.searchVersions(iosVersion, page, size));
    }
}
