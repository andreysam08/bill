package ru.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.TransactionDto;
import org.example.dto.TransactionDtoRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.demo.service.TransactionService;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER')")
    TransactionDto create(@RequestBody TransactionDtoRequest transactionDtoRequest, Authentication authentication) {
        return transactionService.save(transactionDtoRequest, UUID.fromString(((Jwt) authentication.getPrincipal()).getClaims().get("userId").toString()));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    TransactionDto getLsatTransaction(Authentication authentication) {
        return transactionService.getLastTransaction(UUID.fromString(((Jwt) authentication.getPrincipal()).getClaims().get("userId").toString()));
    }
}
