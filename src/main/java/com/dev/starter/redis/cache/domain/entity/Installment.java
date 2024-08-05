package com.dev.starter.redis.cache.domain.entity;

import com.dev.starter.redis.cache.domain.enums.InstallmentType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Installment  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String identifier;
    private String accountId;
    private BigDecimal value;
    private LocalDate dueDate;
    private boolean enabled;
    private InstallmentType type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Installment create(final String accountIdentifier,
                                     final BigDecimal value,
                                     final LocalDate dueDate) {
        return new Installment(
                UUID.randomUUID().toString(),
                accountIdentifier,
                value,
                dueDate,
                true,
                InstallmentType.PENDING,
                LocalDateTime.now(),
                null
        );
    }
}
