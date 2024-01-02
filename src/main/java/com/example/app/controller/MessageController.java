package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping("hello")
    public String hello(Locale locale){
        return Messages.get("hello.message", locale);
    }
}
