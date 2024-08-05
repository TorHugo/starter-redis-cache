package com.dev.starter.redis.cache.infrastructure.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InstallmentDTO(
        @JsonProperty("account_identifier") String accountIdentifier,
        @JsonProperty("value") BigDecimal value,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
        @JsonProperty("due_date") LocalDate dueDate
) {
}
