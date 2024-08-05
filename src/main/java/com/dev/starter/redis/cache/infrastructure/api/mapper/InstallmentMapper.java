package com.dev.starter.redis.cache.infrastructure.api.mapper;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.infrastructure.api.models.AccountInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.FullAccountDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.FullInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.InstallmentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstallmentMapper {
    public Installment toDomain(final InstallmentDTO request) {
        return Installment.create(
                request.accountIdentifier(),
                request.value(),
                request.dueDate()
        );
    }

    public FullInstallmentDTO fromDomain(final Installment domain){
        return FullInstallmentDTO.builder()
                .identifier(domain.getIdentifier())
                .accountIdentifier(domain.getAccountId())
                .value(domain.getValue())
                .dueDate(domain.getDueDate())
                .enabled(domain.isEnabled())
                .type(domain.getType().toString())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public AccountInstallmentDTO toResponse(final FullAccountDTO account,
                                            final List<FullInstallmentDTO> installments){
        return AccountInstallmentDTO.builder()
                .account(account)
                .installments(installments)
                .build();
    }

    public List<FullInstallmentDTO> fromDomainList(final List<Installment> installments){
        return installments.stream().map(this::fromDomain).toList();
    }
}
