package com.boot.simpledb.repository;

import com.boot.simpledb.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRedisRepo extends CrudRepository<Book, String> {
}
