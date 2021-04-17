package com.boot.simpledb.service;

import com.boot.simpledb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookRepo {
    @Autowired
    private RedisTemplate<String, Book> redisTemplate;

    public void save(Book book) {
        redisTemplate.opsForValue().set(book.id, book);
    }

    public Book findById(Long id) {
        return redisTemplate.opsForValue().get(id);
    }
}