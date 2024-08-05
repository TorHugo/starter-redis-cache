package com.dev.starter.redis.cache.infrastructure.api.models;

import lombok.Builder;

@Builder
public record AccountDTO(
        String username,
        String email
) {
}
