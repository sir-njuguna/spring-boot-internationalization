package com.example.app;

import org.springframework.context.MessageSource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class Messages {
    private static MessageSource messageSource;

    public Messages(MessageSource messageSource) {
        Messages.messageSource = messageSource;
    }

    public static String get( @NonNull String msgCode){
        return get(msgCode, Locale.ENGLISH);
    }

    public static String get( @NonNull String msgCode, @NonNull Locale locale){
        return Messages.messageSource.getMessage(msgCode, null, locale);
    }
}
