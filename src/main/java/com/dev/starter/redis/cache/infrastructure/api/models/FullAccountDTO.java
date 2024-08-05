package com.dev.starter.redis.cache.infrastructure.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FullAccountDTO(
        @JsonProperty("identifier") String identifier,
        @JsonProperty("username") String username,
        @JsonProperty("email") String email,
        @JsonProperty("created_at") LocalDateTime createdAt,
        @JsonProperty("updated_at") LocalDateTime updatedAt
) {
}
