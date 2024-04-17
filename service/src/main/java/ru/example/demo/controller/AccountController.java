package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.service.AccountService;
import ru.example.demo.dto.AccountDto;
import ru.example.demo.dto.AccountDtoRequest;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    AccountDto create(@RequestBody AccountDtoRequest accountDtoRequest) {
        return accountService.save(accountDtoRequest);
    }
}
