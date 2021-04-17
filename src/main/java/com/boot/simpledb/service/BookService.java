package com.boot.simpledb.service;

import com.boot.simpledb.model.Book;
import com.boot.simpledb.repository.BookRedisRepo;
import com.boot.simpledb.repository.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRedisRepo bookRedisRepo;

    @Autowired
    private BookRepo bookRepo;

    public Book save(Book book) {
        log.info("save: book: {}, thread: {}", book, Thread.currentThread());

        Book savedBook = bookRepo.save(book);
        bookRedisRepo.redisCacheUpdate(book.id, savedBook);

        return savedBook;
    }

    public Book findById(String id) {
        log.info("findById: id: {}", id);

        Book book = bookRedisRepo.redisCacheGet(id);
        if (book == null) {
            log.info("Cache Miss: Querying DB");

            book = bookRepo.findById(id)
                    .map(b -> {
                        bookRedisRepo.redisCachePut(b);
                        return b;
                    })
                    .orElse(null);
        }

        return book;
    }
}