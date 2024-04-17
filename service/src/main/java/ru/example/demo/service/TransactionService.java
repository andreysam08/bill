package ru.example.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.example.demo.dto.AccountDto;
import ru.example.demo.dto.TransactionDto;
import ru.example.demo.dto.TransactionDtoRequest;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.AttemptTransaction;
import ru.example.demo.entity.Transaction;
import ru.example.demo.entity.enums.TransactionType;
import ru.example.demo.repository.TransactionRepository;
import ru.example.demo.mapper.TransactionMapper;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final TransactionMapper transactionMapper;
    private final AttemptTransactionService attemptTransactionService;

    //@Transactional(isolation = Isolation.REPEATABLE_READ)
    @Transactional
    public TransactionDto save(TransactionDtoRequest transactionDtoRequest) {
        Account account = accountService.getById(transactionDtoRequest.accountId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AttemptTransaction attemptTransaction = attemptTransactionService.saveAttemptTransaction(
                transactionMapper.mapAttemptTransaction(transactionDtoRequest, account));
        if (transactionDtoRequest.type().equals(TransactionType.CREDIT)) {
            account.setBalance(account.getBalance().add(transactionDtoRequest.amount()));
        } else {
            if (account.getBalance().compareTo(transactionDtoRequest.amount()) >= 0) {
                account.setBalance(account.getBalance().subtract(transactionDtoRequest.amount()));
            } else {
                throw new RuntimeException("Недостаточно средств");
            }
        }
        Transaction transaction = transactionRepository.save(transactionMapper.map(transactionDtoRequest, account));
        // В данном случе из-за Propagation.NEW на необходимо ещё раз сделать запрос в БД, чтобы сущность обновилась
        attemptTransactionService.findById(attemptTransaction.getId()).setTransaction(transaction);
        return transactionMapper.map(transaction, "success");
    }
}
