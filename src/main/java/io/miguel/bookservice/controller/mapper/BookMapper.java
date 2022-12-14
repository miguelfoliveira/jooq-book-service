package io.miguel.bookservice.controller.mapper;

import io.miguel.bookservice.controller.model.BookDTO;
import io.miguel.bookservice.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
    BookDTO toBookDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book fromBookDto(BookDTO bookDTO);
}
