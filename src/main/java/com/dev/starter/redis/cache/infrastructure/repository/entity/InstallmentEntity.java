package com.dev.starter.redis.cache.infrastructure.repository.entity;

import com.dev.starter.redis.cache.domain.enums.InstallmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Table(name = "installment_tb")
@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class InstallmentEntity {

    @Id
    private String identifier;
    @Column(nullable = false, updatable = false)
    private String accountIdentifier;
    @Column(nullable = false)
    private BigDecimal value;
    @Column(nullable = false)
    private LocalDate dueDate;
    private boolean enabled;

    @Enumerated(STRING)
    private InstallmentType type;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
