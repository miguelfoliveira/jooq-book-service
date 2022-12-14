package io.miguel.bookservice.service;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class CurrentTimeDateTimeService implements DateTimeService{
    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    @Override
    public Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
