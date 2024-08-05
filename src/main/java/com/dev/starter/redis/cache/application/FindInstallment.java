package com.dev.starter.redis.cache.application;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.domain.gateway.InstallmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindInstallment {
    private final InstallmentGateway installmentGateway;

    public Installment execute(final String identifier){
        return installmentGateway.getInstallment(identifier);
    }
}
