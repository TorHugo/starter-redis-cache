package com.dev.starter.redis.cache.infrastructure.repository.mapper;

import com.dev.starter.redis.cache.domain.entity.Account;
import com.dev.starter.redis.cache.infrastructure.repository.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountEntityMapper {
    public AccountEntity fromAggregate(final Account aggregate) {
        return new AccountEntity(
                aggregate.getIdentifier(),
                aggregate.getUsername(),
                aggregate.getEmail(),
                aggregate.getCreatedAt(),
                aggregate.getUpdatedAt()
        );
    }
    public Account toAggregate(final AccountEntity entity) {
        return new Account(
                entity.getIdentifier(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
