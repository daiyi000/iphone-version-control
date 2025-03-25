package com.aeasy.iphoneversioncontrol.repository;

import com.aeasy.iphoneversioncontrol.model.Version;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Long> {
    Page<Version> findByIosVersionContaining(String iosVersion, Pageable pageable);
}
