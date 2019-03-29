package com.example.testframe.event.guava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Event {
    private final String message;

    public Event(String message) {
        this.message = message;
        log.info("Test message : {}", message);
    }

    public String getMessage() {
        return message;
    }
}
