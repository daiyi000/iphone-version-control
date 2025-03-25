package com.aeasy.iphoneversioncontrol.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VersionStatus {
    @JsonProperty("ACTIVE") // 确保 JSON 能解析
    ACTIVE,

    @JsonProperty("DEPRECATED")
    DEPRECATED;
}

