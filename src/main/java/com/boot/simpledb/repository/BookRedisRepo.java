package com.boot.simpledb.repository;

import com.boot.simpledb.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BookRedisRepo {
    Logger log = LoggerFactory.getLogger(BookRedisRepo.class);

    @Autowired
    private RedisTemplate<String, Book> redisTemplate;

    @Async("specificTaskExecutor")
    public void redisCacheEvict(String bookId) {
        log.info("redisCacheEvict: bookId: {}, thread: {}", bookId, Thread.currentThread());

        redisTemplate.delete(bookId);
    }

    @Async("specificTaskExecutor")
    public void redisCachePut(Book book) {
        log.info("redisCachePut: book: {}, thread: {}", book, Thread.currentThread());

        redisTemplate.opsForValue().set(book.id, book);
    }

    @Async("specificTaskExecutor")
    public void redisCacheUpdate(String bookId, Book updatedBook) {
        log.info("redisCacheUpdate: ");

        redisCacheEvict(bookId);
        redisCachePut(updatedBook);
    }

    public Book redisCacheGet(String id) {
        log.info("redisCacheGet: id: {}", id);

        return redisTemplate.opsForValue().get(id);
    }
}
