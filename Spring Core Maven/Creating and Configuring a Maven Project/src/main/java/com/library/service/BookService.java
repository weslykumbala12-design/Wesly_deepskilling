package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    public void setBookRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void service() {

        System.out.println("Book Service Working...");

        repository.display();
    }
}