package com.connectocean.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.connectocean.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAllBooks() {
        final String sqlQuery = "SELECT ID, Title, Author from Books";
        final List<Book> books = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public Book getBook(final int id) {
        final String sqlQuery = "SELECT ID, Title, Author from Books WHERE ID = ?";
        final Book book = jdbcTemplate.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(Book.class), id);
        return book;
    }

    @Override
    public long addBook(final Book book) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Books").usingGeneratedKeyColumns("ID");
        return simpleJdbcInsert.executeAndReturnKey(book.toMap()).longValue();
    }

    @Override
    public int updateBook(final Book book) {
        final String sqlQuery = "UPDATE Books SET Title = ?, Author = ? WHERE ID = ?";
        return jdbcTemplate.update(sqlQuery, book.getTitle(), book.getAuthor(), book.getId());
    }

    @Override
    public int deleteBook(final int id) {
        final String sqlQuery = "DELETE FROM Books WHERE ID = ?";
        return jdbcTemplate.update(sqlQuery, id);
    }
}