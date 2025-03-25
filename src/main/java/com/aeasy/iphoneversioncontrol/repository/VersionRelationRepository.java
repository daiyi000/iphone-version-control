package com.aeasy.iphoneversioncontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeasy.iphoneversioncontrol.model.VersionRelation;

public interface VersionRelationRepository extends JpaRepository<VersionRelation, Long> {

    // 根据源版本ID查询
    List<VersionRelation> findBySourceVersionId(Long sourceVersionId);

    // 根据目标版本ID查询
    List<VersionRelation> findByTargetVersionId(Long targetVersionId);

    // 其他自定义查询方法...
}
