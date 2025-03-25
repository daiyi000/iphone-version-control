package com.aeasy.iphoneversioncontrol.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_version")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // iOS Version
    @Column(name = "ios_version", nullable = false)
    @JsonProperty("iosVersion")
    private String iosVersion;

    // 版本的发布时间
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "release_date")
    private LocalDate releaseDate;

    // 更新说明
    @Column(name = "changelog", columnDefinition = "TEXT")
    private String changelog;

    // 状态(枚举: ACTIVE / DEPRECATED)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VersionStatus status;

    // 关联到设备的ID
    private Long deviceId;

    // 版本创建时间
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "creation_time")
    private LocalDate creationTime;

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", iosVersion='" + iosVersion + '\'' +
                ", releaseDate=" + releaseDate +
                ", changelog='" + changelog + '\'' +
                ", status=" + status +
                ", deviceId=" + deviceId +
                ", creationTime=" + creationTime +
                '}';
    }
}
