package ru.example.demo.mapper;

import org.example.dto.TransactionDto;
import org.example.dto.TransactionDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.AttemptTransaction;
import ru.example.demo.entity.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastActionDate", ignore = true)
    Transaction map(TransactionDtoRequest transactionDtoRequest, Account account);

    @Mapping(target = "status", source = "status")
    TransactionDto map(Transaction transaction, String status);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastActionDate", ignore = true)
    AttemptTransaction mapAttemptTransaction(TransactionDtoRequest transactionDtoRequest, Account account);

    List<TransactionDto> map(List<Transaction> transactions);
}
