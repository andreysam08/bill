package ru.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.example.demo.entity.enums.TransactionType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction", schema = "bill")
public class Transaction extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    @OneToOne(mappedBy = "transaction")
    private AttemptTransaction attemptTransaction;
}
