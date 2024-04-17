package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demo.dto.AccountDto;
import ru.example.demo.dto.AccountDtoRequest;
import ru.example.demo.dto.TransactionDto;
import ru.example.demo.dto.TransactionDtoRequest;
import ru.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    TransactionDto create(@RequestBody TransactionDtoRequest transactionDtoRequest) {
        return transactionService.save(transactionDtoRequest);
    }
}
