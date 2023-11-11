package org.example.service;

import org.example.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    public void save(Book book) {
        System.out.println("book = " + book);
    }

    public void update(Book book) {
        System.out.println("book = " + book);
    }

    public void delete(Book book) {
        System.out.println("book = " + book);
    }

    public void findById(Book book) {
        System.out.println("book = " + book);
    }
}
