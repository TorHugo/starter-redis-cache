package com.dev.starter.redis.cache.infrastructure.api.controller;

import com.dev.starter.redis.cache.application.CreateAccount;
import com.dev.starter.redis.cache.infrastructure.api.AccountAPI;
import com.dev.starter.redis.cache.infrastructure.api.mapper.AccountMapper;
import com.dev.starter.redis.cache.infrastructure.api.models.AccountDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.SuccessfullyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountAPI {
    private final AccountMapper accountMapper;
    private final CreateAccount createAccount;

    @Override
    public SuccessfullyDTO create(final AccountDTO dto) {
        return new SuccessfullyDTO(createAccount.execute(accountMapper.toDomain(dto)));
    }
}
