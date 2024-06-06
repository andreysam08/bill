package com.example.client.service;

import org.example.dto.TransactionDto;
import org.example.dto.TransactionDtoRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Service
@RequestMapping
public class TransactionService {
    @Value("${service.host}")
    private String serverHost;
    public TransactionDto makeTransaction(OAuth2AuthorizedClient authorizedClient, TransactionDtoRequest transactionDtoRequest) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
        HttpEntity<String> request = new HttpEntity<>(transactionDtoRequest.toString(), headers);
        String url = serverHost + "/transaction";
        return template.postForObject(url, request, TransactionDto.class);
    }

    public TransactionDto getLastTransaction(OAuth2AuthorizedClient authorizedClient) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue());
        HttpEntity<String> request = new HttpEntity<>(headers);
        String url = serverHost + "/transaction";
        return template.exchange(url, HttpMethod.GET, request, TransactionDto.class).getBody();
    }
}
