package com.boot.simpledb.controller;

import com.boot.simpledb.model.Book;
import com.boot.simpledb.service.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class BookController {

    Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    BookRepo bookRepo;

    @PostMapping("/book")
    ResponseEntity addBook(@RequestBody Book book) {
        log.info("addBook: Book: {}", book);

        bookRepo.save(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    @GetMapping("/book/{id}")
    ResponseEntity getBook(@PathVariable String id) {
        log.info("getBook: id: {}", id);

        Book res = bookRepo.findById(id);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }
}
