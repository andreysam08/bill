package com.example.client.controller;

import com.example.client.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.example.dto.TransactionDto;
import org.example.dto.TransactionDtoRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
