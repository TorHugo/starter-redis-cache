package com.dev.starter.redis.cache.infrastructure.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SuccessfullyDTO(
        @JsonProperty("identifier_value") String identifier
) {
}
