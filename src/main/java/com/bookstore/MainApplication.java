package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistAuthorWithBooks();
            bookstoreService.displayAuthorWithBooks();
        };
    }
}
/*
 * How To Provide a Fluent API Via Additional Methods For Building Entities

Note: If you want yo provide a Fluent API by altering setters then consider this item.

Description: This is a sample application that add in entities additional methods (e.g., for setName, we add name) methods in order to empower a Fluent API.

Key points:

in entities, add for each setter an additional method that return this instead of void
Fluent API example:

 */
