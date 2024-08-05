package com.dev.starter.redis.cache.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String identifier;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Account create(final String username, final String email) {
        return new Account(
                UUID.randomUUID().toString(),
                username,
                email,
                LocalDateTime.now(),
                null
        );
    }
}
