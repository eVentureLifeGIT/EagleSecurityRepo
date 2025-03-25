package com.connectocean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectocean.model.Book;
import com.connectocean.repository.BookRepository;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookRepository.getBook(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/book")
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = { Exception.class, RuntimeException.class })
    public long addBook(@RequestBody Book book) {
        return bookRepository.addBook(book);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/book")
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = { Exception.class, RuntimeException.class })
    public int updateBook(@RequestBody Book book) {
        return bookRepository.updateBook(book);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/book/{id}")
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = { Exception.class, RuntimeException.class })
    public int deleteBook(@PathVariable("id") int id) {
        return bookRepository.deleteBook(id);
    }
}