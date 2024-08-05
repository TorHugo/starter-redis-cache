package com.dev.starter.redis.cache.infrastructure.gateway;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.domain.gateway.InstallmentGateway;
import com.dev.starter.redis.cache.infrastructure.repository.InstallmentRepository;
import com.dev.starter.redis.cache.infrastructure.repository.mapper.InstallmentEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InstallmentGatewayImpl implements InstallmentGateway {

    private final InstallmentRepository installmentRepository;
    private final InstallmentEntityMapper installmentEntityMapper;

    @Override
    public String save(final Installment installment) {
        return installmentRepository.save(installmentEntityMapper.fromAggregate(installment)).getIdentifier();
    }

    @Override
    @Cacheable(value = "accountInstallments", key = "#identifier")
    public List<Installment> getAllInstallmentByAccount(final String identifier) {
        final var entities = installmentRepository.findByAccountIdentifier(identifier);
        return entities.stream().map(
                installmentEntityMapper::toAggregate
        ).toList();
    }

    @Override
    @Cacheable(value = "installment", key = "#identifier")
    public Installment getInstallment(final String identifier) {
        final var entity = installmentRepository.findById(identifier).orElse(null);
        return Objects.isNull(entity) ? null : installmentEntityMapper.toAggregate(entity);
    }
}
