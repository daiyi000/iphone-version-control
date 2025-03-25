package com.aeasy.iphoneversioncontrol.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeasy.iphoneversioncontrol.model.Version;
import com.aeasy.iphoneversioncontrol.model.VersionRelation;
import com.aeasy.iphoneversioncontrol.repository.VersionRelationRepository;
import com.aeasy.iphoneversioncontrol.repository.VersionRepository;

import java.util.List;

@Service
public class VersionRelationService {

    @Autowired
    private VersionRelationRepository versionRelationRepository;

    @Autowired
    private VersionRepository versionRepository;

    /**
     * 创建关联
     */
    public VersionRelation createRelation(Long sourceVersionId, Long targetVersionId, String relationType) {
        Version source = versionRepository.findById(sourceVersionId)
                .orElseThrow(() -> new RuntimeException("Source Version not found"));
        Version target = versionRepository.findById(targetVersionId)
                .orElseThrow(() -> new RuntimeException("Target Version not found"));

        VersionRelation relation = new VersionRelation();
        relation.setSourceVersion(source);
        relation.setTargetVersion(target);
        relation.setRelationType(relationType);

        return versionRelationRepository.save(relation);
    }

    /**
     * 删除关联
     */
    public void deleteRelation(Long relationId) {
        versionRelationRepository.deleteById(relationId);
    }

    /**
     * 查询所有关联
     */
    public List<VersionRelation> findAll() {
        return versionRelationRepository.findAll();
    }

    /**
     * 根据主键查询
     */
    public VersionRelation findById(Long id) {
        return versionRelationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relation not found"));
    }

    /**
     * 更新关联（如果你想修改 relationType）
     */
    public VersionRelation updateRelation(Long relationId, Long sourceVersionId, Long targetVersionId, String relationType) {
        VersionRelation relation = findById(relationId);

        // 也可根据业务决定是否允许修改 source/target
        if (sourceVersionId != null) {
            Version source = versionRepository.findById(sourceVersionId)
                    .orElseThrow(() -> new RuntimeException("Source Version not found"));
            relation.setSourceVersion(source);
        }
        if (targetVersionId != null) {
            Version target = versionRepository.findById(targetVersionId)
                    .orElseThrow(() -> new RuntimeException("Target Version not found"));
            relation.setTargetVersion(target);
        }
        if (relationType != null) {
            relation.setRelationType(relationType);
        }

        return versionRelationRepository.save(relation);
    }
}
