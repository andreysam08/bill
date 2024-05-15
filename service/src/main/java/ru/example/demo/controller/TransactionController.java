package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.dto.TransactionDto;
import ru.example.demo.dto.TransactionDtoRequest;
import ru.example.demo.service.TransactionService;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    TransactionDto create(@RequestBody TransactionDtoRequest transactionDtoRequest, Authentication authentication) {
        return transactionService.save(transactionDtoRequest, UUID.fromString(((Jwt) authentication.getPrincipal()).getClaims().get("userId").toString()));
    }

    @GetMapping
    TransactionDto getLsatTransaction(Authentication authentication) {
        return transactionService.getLastTransaction(UUID.fromString(((Jwt) authentication.getPrincipal()).getClaims().get("userId").toString()));
    }
}
