package com.dev.starter.redis.cache.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "account_tb")
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    private String identifier;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
