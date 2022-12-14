package io.miguel.bookservice.service;

import io.miguel.bookservice.model.Book;
import io.miguel.bookservice.repository.JOOQBookRepository;
import io.miguel.bookservice.tables.records.BookRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final CurrentTimeDateTimeService dateTimeService;

    private final JOOQBookRepository jooqBookRepository;

    public BookService(CurrentTimeDateTimeService dateTimeService, JOOQBookRepository jooqBookRepository) {
        this.dateTimeService = dateTimeService;
        this.jooqBookRepository = jooqBookRepository;
    }

    public void add(Book bookEntry) {
        Integer addResult = jooqBookRepository.add(createRecord(bookEntry));
        if (addResult != 1){
            throw new IllegalArgumentException("something happened");
        }
    }

    public List<Book> findAll() {
        List<BookRecord> bookRecords = jooqBookRepository.findAll();
        return bookRecords.stream().map(this::convertQueryResultToModelObject)
                .collect(Collectors.toList());
    }

    private Book convertQueryResultToModelObject(BookRecord queryResult) {
        return Book.builder()
                .id(queryResult.getId())
                .title(queryResult.getTitle())
                .creationTime(queryResult.getCreationtime())
                .modificationTime(queryResult.getModificationtime())
                .build();
    }

    private BookRecord createRecord(Book bookEntry) {
        LocalDateTime currentTime = dateTimeService.getCurrentDateTime();
        BookRecord bookRecord = new BookRecord();
        bookRecord.setCreationtime(currentTime);
        bookRecord.setTitle(bookEntry.getTitle());

        return bookRecord;
    }
}
