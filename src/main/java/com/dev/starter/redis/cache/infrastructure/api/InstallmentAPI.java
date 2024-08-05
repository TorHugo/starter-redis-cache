package com.dev.starter.redis.cache.infrastructure.api;

import com.dev.starter.redis.cache.infrastructure.api.models.AccountInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.FullInstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.InstallmentDTO;
import com.dev.starter.redis.cache.infrastructure.api.models.SuccessfullyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/installments")
public interface InstallmentAPI {
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    SuccessfullyDTO create(final @RequestBody InstallmentDTO request);

    @GetMapping("/find-all/{accountIdentifier}")
    @ResponseStatus(HttpStatus.CREATED)
    AccountInstallmentDTO findAll(final @PathVariable String accountIdentifier);

    @GetMapping("/find/{installmentIdentifier}")
    @ResponseStatus(HttpStatus.CREATED)
    FullInstallmentDTO findInstallment(final @PathVariable String installmentIdentifier);
}
