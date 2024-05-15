package com.example.client.controller;

import com.example.client.dto.TransactionDto;
import com.example.client.dto.TransactionDtoRequest;
import com.example.client.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionDto makeTransaction(@RegisteredOAuth2AuthorizedClient("oidc-client") OAuth2AuthorizedClient authorizedClient,
                                          @RequestBody TransactionDtoRequest transactionDtoRequest) {
        return transactionService.makeTransaction(authorizedClient, transactionDtoRequest);
    }

    @GetMapping
    public TransactionDto getTransaction(@RegisteredOAuth2AuthorizedClient("oidc-client") OAuth2AuthorizedClient authorizedClient) {
        return transactionService.getLastTransaction(authorizedClient);
    }
}
