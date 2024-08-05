package com.dev.starter.redis.cache.domain.gateway;

import com.dev.starter.redis.cache.domain.entity.Installment;

import java.util.List;

public interface InstallmentGateway {
    String save(final Installment installment);
    List<Installment> getAllInstallmentByAccount(final String identifier);
    Installment getInstallment(final String identifier);
}
