package com.aeasy.iphoneversioncontrol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aeasy.iphoneversioncontrol.model.VersionRelation;
import com.aeasy.iphoneversioncontrol.service.VersionRelationService;

/**
 * 管理版本之间的关联关系
 */
@RestController
@RequestMapping("/api/version-relations")
public class VersionRelationController {

    @Autowired
    private VersionRelationService versionRelationService;

    // DTO 用于创建/更新关联
    static class RelationRequest {
        public Long sourceVersionId;
        public Long targetVersionId;
        public String relationType;
        // getter/setter ...
    }

    /**
     * 获取所有关联
     */
    @GetMapping
    public ResponseEntity<?> getAllRelations() {
        return ResponseEntity.ok(versionRelationService.findAll());
    }

    /**
     * 创建关联
     */
    @PostMapping
    public ResponseEntity<?> createRelation(@RequestBody RelationRequest req) {
        VersionRelation saved = versionRelationService.createRelation(
                req.sourceVersionId,
                req.targetVersionId,
                req.relationType
        );
        return ResponseEntity.ok(saved);
    }

    /**
     * 更新关联
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRelation(@PathVariable Long id,
                                           @RequestBody RelationRequest req) {
        VersionRelation updated = versionRelationService.updateRelation(
                id,
                req.sourceVersionId,
                req.targetVersionId,
                req.relationType
        );
        return ResponseEntity.ok(updated);
    }

    /**
     * 删除关联
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRelation(@PathVariable Long id) {
        versionRelationService.deleteRelation(id);
        return ResponseEntity.noContent().build();
    }
}
