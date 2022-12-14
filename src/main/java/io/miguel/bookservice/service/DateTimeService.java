package io.miguel.bookservice.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface DateTimeService {
    public LocalDateTime getCurrentDateTime();

    public Timestamp getCurrentTimestamp();
}
