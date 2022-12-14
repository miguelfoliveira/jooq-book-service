package io.miguel.bookservice.repository;

import io.miguel.bookservice.model.Book;
import io.miguel.bookservice.tables.records.BookRecord;

import java.util.List;

public interface BookRepository {
    public Integer add(BookRecord bookRecord);
    public Book delete(Long id);
    public List<BookRecord> findAll();

}
