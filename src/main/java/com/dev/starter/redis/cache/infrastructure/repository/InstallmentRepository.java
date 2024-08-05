package com.dev.starter.redis.cache.infrastructure.repository;

import com.dev.starter.redis.cache.infrastructure.repository.entity.InstallmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository extends JpaRepository<InstallmentEntity, String> {
    List<InstallmentEntity> findByAccountIdentifier(final String accountIdentifier);
}
