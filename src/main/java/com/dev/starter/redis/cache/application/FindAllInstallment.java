package com.dev.starter.redis.cache.application;

import com.dev.starter.redis.cache.domain.entity.Installment;
import com.dev.starter.redis.cache.domain.gateway.InstallmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllInstallment {
    private final InstallmentGateway installmentGateway;

    public List<Installment> execute(final String identifier){
        return installmentGateway.getAllInstallmentByAccount(identifier);
    }
}
