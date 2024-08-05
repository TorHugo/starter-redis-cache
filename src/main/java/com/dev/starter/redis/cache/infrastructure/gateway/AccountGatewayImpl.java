package com.dev.starter.redis.cache.infrastructure.gateway;

import com.dev.starter.redis.cache.domain.entity.Account;
import com.dev.starter.redis.cache.domain.gateway.AccountGateway;
import com.dev.starter.redis.cache.infrastructure.repository.AccountRepository;
import com.dev.starter.redis.cache.infrastructure.repository.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AccountGatewayImpl implements AccountGateway {
    private final AccountRepository repository;
    private final AccountEntityMapper mapper;

    @Override
    public String save(final Account account) {
        return repository.save(mapper.fromAggregate(account)).getIdentifier();
    }

    @Cacheable(value = "accounts", key = "#identifier")
    @Override
    public Account getAccount(final String identifier) {
        final var entity = repository.findById(identifier).orElse(null);
        return Objects.isNull(entity) ? null : mapper.toAggregate(entity);
    }
}
