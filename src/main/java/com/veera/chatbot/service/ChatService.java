package com.veera.chatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ChatService {

    @Value("${huggingface.api.key}")
    private String apiKey;

    public String askBot(String userInput) {

        System.out.println("HF KEY = " + apiKey);

        String url = "https://router.huggingface.co/v1/chat/completions";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();

        body.put("model", "meta-llama/Llama-3.1-8B-Instruct");

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", userInput);

        messages.add(message);

        body.put("messages", messages);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        request,
                        Map.class
                );

        Map responseBody = response.getBody();

        List choices = (List) responseBody.get("choices");

        Map firstChoice = (Map) choices.get(0);

        Map assistantMessage =
                (Map) firstChoice.get("message");

        return assistantMessage.get("content").toString();
    }
}