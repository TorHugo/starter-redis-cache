package com.dev.starter.redis.cache.infrastructure.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record FullInstallmentDTO(
        @JsonProperty("identifier") String identifier,
        @JsonProperty("account_identifier") String accountIdentifier,
        @JsonProperty("value") BigDecimal value,
        @JsonProperty("due_date") LocalDate dueDate,
        @JsonProperty("enabled") boolean enabled,
        @JsonProperty("type") String type,
        @JsonProperty("created_at") LocalDateTime createdAt,
        @JsonProperty("updated_at") LocalDateTime updatedAt
) {
}
