package com.black.demo.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;

@Component
public class TokenGen {

//    public TokenGen() {
//        clientId = env.getProperty("client.id");
//        clientSecretId = env.getProperty("client.secret.id");
//    }
//
////    @Value("${client.id}")
//    private String clientId;
//
////    @Value("${client.secret.id}")
//    private String clientSecretId;
//
//    @Autowired
//    private Environment env;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String tokenGenFunc() {
        String tokenEndpoint = "https://accounts.spotify.com/api/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String clientId = "3a410c3e83574e56ba4c4ecf31f3cd00";
        String clientSecretId = "25e1dab93f834e57bf6428686e61bfa5";
        String requestBody = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecretId;
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(tokenEndpoint, request, String.class);

        // Handle the response as needed
        System.out.println("Response: " + response.getBody());

        JsonNode objNode;
        try {
            objNode = objectMapper.readTree(response.getBody());
            return objNode.get("access_token").toString();
        } catch (JsonProcessingException jse) {
            jse.printStackTrace();
        }

        return null;
    }
}
