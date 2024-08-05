package com.dev.starter.redis.cache.infrastructure.repository.mapper;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.infrastructure.repository.entity.InstallmentEntity;
import org.springframework.stereotype.Component;

@Component
public class InstallmentEntityMapper {
    public InstallmentEntity fromAggregate(final Installment aggregate){
        return new InstallmentEntity(
                aggregate.getIdentifier(),
                aggregate.getAccountId(),
                aggregate.getValue(),
                aggregate.getDueDate(),
                aggregate.isEnabled(),
                aggregate.getType(),
                aggregate.getCreatedAt(),
                aggregate.getUpdatedAt()
        );
    }

    public Installment toAggregate(final InstallmentEntity entity){
        return new Installment(
                entity.getIdentifier(),
                entity.getAccountIdentifier(),
                entity.getValue(),
                entity.getDueDate(),
                entity.isEnabled(),
                entity.getType(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
