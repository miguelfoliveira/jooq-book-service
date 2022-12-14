package io.miguel.bookservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Book {
    private final Integer id;
    private final String title;
    private final LocalDateTime creationTime;
    private final LocalDateTime modificationTime;
}
