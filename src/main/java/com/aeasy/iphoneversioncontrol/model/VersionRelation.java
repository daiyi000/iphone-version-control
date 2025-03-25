package com.aeasy.iphoneversioncontrol.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_version_relation")
public class VersionRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 源版本
    @ManyToOne
    @JoinColumn(name = "source_version_id")
    private Version sourceVersion;

    // 目标版本
    @ManyToOne
    @JoinColumn(name = "target_version_id")
    private Version targetVersion;

    // 关联类型，例如依赖、阻塞等
    @Column(name = "relation_type")
    private String relationType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // 如果需要自动生成创建时间，可以在字段上加 @PrePersist
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Version getSourceVersion() {
		return sourceVersion;
	}

	public void setSourceVersion(Version sourceVersion) {
		this.sourceVersion = sourceVersion;
	}

	public Version getTargetVersion() {
		return targetVersion;
	}

	public void setTargetVersion(Version targetVersion) {
		this.targetVersion = targetVersion;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // getter/setter ...
    
}
