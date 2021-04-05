package com.boot.simpledb.controller;

import com.boot.simpledb.model.Book;
import com.boot.simpledb.model.ShoppingCart;
import com.boot.simpledb.model.ShoppingCartItem;
import com.boot.simpledb.service.BookRepo;
import com.boot.simpledb.service.ShoppingCartService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
    Logger log = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    BookRepo bookRepo;

    @GetMapping
    ResponseEntity demo() {
        log.info("demo: ");

        return ResponseEntity
                .ok()
                .body("Hello!!");
    }

    @GetMapping("/shoppingCart/{userId}")
    ResponseEntity shoppingCartItems(@PathVariable @NonNull String userId) {
        log.info("demo: userId: {}", userId);

        try {
            long userIdLongVal = Long.parseLong(userId);

            ShoppingCart res = shoppingCartService.fetchShoppingCartItemsByUserId(userIdLongVal);

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(res);
        } catch (NumberFormatException exp) {
            log.error("userId conversion error: {}", exp);

            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }

    @PostMapping("/item")
    ResponseEntity addItem(@RequestBody ShoppingCartItem shoppingCartItem) {
        log.info("addItem: ShoppingCartItem: {}", shoppingCartItem);

        ShoppingCartItem res = shoppingCartService.addItem(shoppingCartItem);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }

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
    ResponseEntity getBook(@PathVariable Long id) {
        log.info("getBook: id: {}", id);

        Book res = bookRepo.findById(id);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }
}
