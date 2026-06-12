package com.veera.chatbot.controller;

import com.veera.chatbot.model.ChatRequest;
import com.veera.chatbot.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public Map<String, String> chat(@RequestBody ChatRequest request) {

        String answer = chatService.askBot(request.getQuestion());

        Map<String, String> response = new HashMap<>();
        response.put("reply", answer);

        return response;
    }
}