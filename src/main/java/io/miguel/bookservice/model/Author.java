package io.miguel.bookservice.model;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public class Author {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Timestamp creationTime;
    private final Timestamp modificationTime;
}
