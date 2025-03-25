package com.aeasy.iphoneversioncontrol.service;

import com.aeasy.iphoneversioncontrol.model.Version;
import com.aeasy.iphoneversioncontrol.repository.VersionRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VersionService {
    @Autowired
    private VersionRepository versionRepository;

    public List<Version> getAllVersions() {
        return versionRepository.findAll();
    }

    public Version addVersion(Version version) {
        // 如果 creationTime 没有传，就用当前日期
        if (version.getCreationTime() == null) {
            version.setCreationTime(LocalDate.now());
        }
        return versionRepository.save(version);
    }

    public Optional<Version> getVersionById(Long id) {
        return versionRepository.findById(id);
    }

    public void deleteVersion(Long id) {
        versionRepository.deleteById(id);
    }

    public Version updateVersion(Long id, Version updatedVersion) {
        return versionRepository.findById(id)
            .map(version -> {
                version.setIosVersion(updatedVersion.getIosVersion());
                version.setReleaseDate(updatedVersion.getReleaseDate());
                version.setChangelog(updatedVersion.getChangelog());
                version.setStatus(updatedVersion.getStatus());
                // 如果更新时 creationTime 为空，则保持原有，不覆盖
                if (updatedVersion.getCreationTime() != null) {
                    version.setCreationTime(updatedVersion.getCreationTime());
                }
                // 更新 deviceId
                version.setDeviceId(updatedVersion.getDeviceId());
                return versionRepository.save(version);
            })
            .orElseThrow(() -> new RuntimeException("Version not found with id " + id));
    }

    public Page<Version> getVersionsByPage(int page, int size) {
        return versionRepository.findAll(PageRequest.of(page, size));
    }
    
    public Page<Version> searchVersions(String iosVersion, int page, int size) {
        return versionRepository.findByIosVersionContaining(iosVersion, PageRequest.of(page, size));
    }
}
