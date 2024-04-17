package ru.example.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.Bank;
import ru.example.demo.entity.User;
import ru.example.demo.repository.AccountRepository;
import ru.example.demo.repository.BankRepository;
import ru.example.demo.repository.UserRepository;
import ru.example.demo.dto.AccountDto;
import ru.example.demo.dto.AccountDtoRequest;
import ru.example.demo.mapper.AccountMapper;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final AccountMapper accountMapper;

    public AccountDto save(AccountDtoRequest accountDtoRequest) {
        User user = userRepository.findById(accountDtoRequest.userId()).orElseThrow();
        Bank bank = bankRepository.findById(accountDtoRequest.bankId()).orElseThrow();
        Account save = accountRepository.save(accountMapper.map(accountDtoRequest, user, bank));
        return accountMapper.map(save);
    }

    public Account getById(UUID accountId) {
        Optional<Account> byId = accountRepository.findById(accountId);
        return byId.orElseThrow();
    }
}
