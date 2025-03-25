package com.connectocean.repository;

import java.util.List;

import com.connectocean.model.Book;

public interface BookRepository {
    List<Book> getAllBooks();

    Book getBook(final int id);

    long addBook(final Book Book);

    int updateBook(final Book Book);

    int deleteBook(final int id);
}