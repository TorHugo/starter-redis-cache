package com.dev.starter.redis.cache.infrastructure.api;

import com.dev.starter.redis.cache.infrastructure.api.models.AccountDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.SuccessfullyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/accounts")
public interface AccountAPI {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    SuccessfullyDTO create(final @RequestBody AccountDTO request);
}
