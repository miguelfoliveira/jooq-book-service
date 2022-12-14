package io.miguel.bookservice.controller;

import io.miguel.bookservice.controller.mapper.BookMapper;
import io.miguel.bookservice.controller.model.BookDTO;
import io.miguel.bookservice.model.Book;
import io.miguel.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody BookDTO bookDTO) {
        bookService.add(bookMapper.fromBookDto(bookDTO));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookDTO> findAll() {
        List<Book> books = bookService.findAll();
        return books.stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }
}
