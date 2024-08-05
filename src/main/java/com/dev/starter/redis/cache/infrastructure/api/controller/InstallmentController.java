package com.dev.starter.redis.cache.infrastructure.api.controller;

import com.dev.starter.redis.cache.application.CreateInstallment;
import com.dev.starter.redis.cache.application.FindAccount;
import com.dev.starter.redis.cache.application.FindAllInstallment;
import com.dev.starter.redis.cache.application.FindInstallment;
import com.dev.starter.redis.cache.infrastructure.api.InstallmentAPI;
import com.dev.starter.redis.cache.infrastructure.api.mapper.AccountMapper;
import com.dev.starter.redis.cache.infrastructure.api.mapper.InstallmentMapper;
import com.dev.starter.redis.cache.infrastructure.api.models.AccountInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.FullInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.InstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.SuccessfullyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InstallmentController implements InstallmentAPI {
    private final InstallmentMapper mapper;
    private final AccountMapper accountMapper;
    private final CreateInstallment createInstallment;
    private final FindAccount findAccount;
    private final FindAllInstallment findAllInstallment;
    private final FindInstallment findInstallment;

    @Override
    public SuccessfullyDTO create(final InstallmentDTO request) {
        return new SuccessfullyDTO(createInstallment.execute(mapper.toDomain(request)));
    }

    @Override
    public AccountInstallmentDTO findAll(final String accountIdentifier) {
        final var account = findAccount.execute(accountIdentifier);
        final var installments = findAllInstallment.execute(accountIdentifier);
        return mapper.toResponse(
                accountMapper.fromDomain(account),
                mapper.fromDomainList(installments)
        );
    }

    @Override
    public FullInstallmentDTO findInstallment(final String installmentIdentifier) {
        return mapper.fromDomain(findInstallment.execute(installmentIdentifier));
    }
}
