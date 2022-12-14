package io.miguel.bookservice.repository;

import io.miguel.bookservice.Tables;
import io.miguel.bookservice.model.Book;
import io.miguel.bookservice.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JOOQBookRepository implements BookRepository {
    private final DSLContext dslContext;

    @Autowired
    public JOOQBookRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional
    @Override
    public Integer add(BookRecord bookRecord) {
        try {
            return dslContext.insertInto(Tables.BOOK)
                    .set(bookRecord)
                    .execute();
        } catch (DataAccessException e) {
            throw new RuntimeException();
        }

    }

    @Override
    public Book delete(Long id) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookRecord> findAll() {
        return dslContext.selectFrom(Tables.BOOK).fetchInto(BookRecord.class);
    }


}
