package com.example.app.service;

import org.springframework.context.MessageSource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get( @NonNull String msgCode){
        return get(msgCode, Locale.ENGLISH);
    }

    public String get( @NonNull String msgCode, @NonNull Locale locale){
        return this.messageSource.getMessage(msgCode, null, locale);
    }
}
