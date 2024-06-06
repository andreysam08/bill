package ru.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.TransactionType;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "attempt_transaction", schema = "bill")
public class AttemptTransaction  extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;
    @OneToOne
    private Transaction transaction;
}
