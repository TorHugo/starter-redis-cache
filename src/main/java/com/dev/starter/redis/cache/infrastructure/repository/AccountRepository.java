package com.dev.starter.redis.cache.infrastructure.repository;

import com.dev.starter.redis.cache.infrastructure.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
