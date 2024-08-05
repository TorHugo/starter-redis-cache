package com.dev.starter.redis.cache.domain.gateway;

import com.dev.starter.redis.cache.domain.entity.Account;

public interface AccountGateway {
    String save(final Account account);
    Account getAccount(final String identifier);
}
