package ru.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.Bank;
import ru.example.demo.entity.User;
import ru.example.demo.dto.AccountDto;
import ru.example.demo.dto.AccountDtoRequest;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto map(Account account);
    Account map(AccountDto accountDto);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastActionDate", ignore = true)
    Account map(AccountDtoRequest accountDtoRequest, User user, Bank bank);
}
