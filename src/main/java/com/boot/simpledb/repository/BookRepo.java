package com.boot.simpledb.repository;

import com.boot.simpledb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, String> {
}
