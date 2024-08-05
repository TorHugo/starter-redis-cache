package com.dev.starter.redis.cache.application;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.domain.gateway.InstallmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateInstallment {

    private final InstallmentGateway installmentGateway;

    public String execute(final Installment installment){
        return installmentGateway.save(installment);
    }
}
