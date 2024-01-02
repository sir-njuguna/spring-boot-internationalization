package com.example.app.controller;

import com.example.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MessageController {
    private MessageService messageService;

    @GetMapping("hello")
    public String hello(Locale locale){
        return messageService.get("hello.message", locale);
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
