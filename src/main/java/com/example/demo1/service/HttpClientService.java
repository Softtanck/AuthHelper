package com.example.demo1.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {

    public String client(String url, HttpMethod httpMethod, MultiValueMap<String, String> params) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(url, String.class);
        return stringResponseEntity.getBody();
    }
}
