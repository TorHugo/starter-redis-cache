package com.dev.starter.redis.cache.infrastructure.api.mapper;

import com.dev.starter.redis.cache.domain.entity.Account;
import com.dev.starter.redis.cache.infrastructure.api.models.AccountDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.FullAccountDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toDomain (final AccountDTO dto){
        return Account.create(dto.username(), dto.email());
    }

    public FullAccountDTO fromDomain(final Account account){
        return FullAccountDTO.builder()
                .identifier(account.getIdentifier())
                .username(account.getUsername())
                .email(account.getEmail())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }
}
