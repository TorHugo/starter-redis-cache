package com.dev.starter.redis.cache.infrastructure.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record AccountInstallmentDTO(
        @JsonProperty("account") FullAccountDTO account,
        @JsonProperty("installments")List<FullInstallmentDTO> installments
)
{
}
