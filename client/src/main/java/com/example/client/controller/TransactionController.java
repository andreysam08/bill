package com.example.client.controller;

import com.example.client.dto.TransactionDto;
import com.example.client.dto.TransactionDtoRequest;
import com.example.client.dto.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
public class TransactionController {

    @Value("${service.host}")
    private String serverHost;

    @GetMapping
    public TransactionDto makeTransaction(@RegisteredOAuth2AuthorizedClient("oidc-client") OAuth2AuthorizedClient authorizedClient) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
        TransactionDtoRequest transactionDto = new TransactionDtoRequest(UUID.fromString("eb607c8c-26c9-4b77-adf9-7293c9970f84"),
                TransactionType.CREDIT, BigDecimal.valueOf(100));
        HttpEntity<String> request = new HttpEntity<String>(transactionDto.toString(), headers);
        String url = serverHost + "/transaction";
        return template.postForObject(url, request, TransactionDto.class);
    }
}
