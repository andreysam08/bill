package ru.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.example.demo.entity.enums.TransactionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account", schema = "bill")
public class Account extends BaseEntity {
    BigDecimal balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public void setUser(User user) {
        this.user = user;
        if (user.getAccounts() == null) {
            user.setAccounts(new ArrayList<>());
        }
        user.getAccounts().add(this);
    }

    public void setBank(Bank bank) {
        this.bank = bank;
        if (bank.getAccounts() == null) {
            bank.setAccounts(new ArrayList<>());
        }
        bank.getAccounts().add(this);
    }
}
