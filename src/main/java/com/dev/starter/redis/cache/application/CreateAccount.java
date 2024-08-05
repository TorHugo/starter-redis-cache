package com.dev.starter.redis.cache.application;

import com.dev.starter.redis.cache.domain.entity.Account;
import com.dev.starter.redis.cache.domain.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccount {

    private final AccountGateway accountGateway;

    public String execute(final Account account){
        return accountGateway.save(account);
    }
}
