package com.example.testframe.ioc.messagesource;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class I18nService {
    private final MessageSource messageSource;

    public I18nService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String msgKey, Object[] args) {
        return messageSource.getMessage(msgKey, args, Locale.getDefault());
    }

    public String getMessage(String msgKey) {
        return messageSource.getMessage(msgKey, null, Locale.getDefault());
    }

}
