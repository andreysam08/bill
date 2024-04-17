package ru.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.example.demo.dto.TransactionDto;
import ru.example.demo.dto.TransactionDtoRequest;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.AttemptTransaction;
import ru.example.demo.entity.Transaction;

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
}
