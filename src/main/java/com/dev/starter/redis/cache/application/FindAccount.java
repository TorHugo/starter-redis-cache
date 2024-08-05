package com.dev.starter.redis.cache.application;

import com.dev.starter.redis.cache.domain.entity.Account;
import com.dev.starter.redis.cache.domain.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAccount {
    private final AccountGateway accountGateway;

    public Account execute(final String identifier){
        return accountGateway.getAccount(identifier);
    }
}
