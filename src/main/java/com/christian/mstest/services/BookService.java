package com.christian.mstest.services;

import com.christian.mstest.model.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {
    //public Book getBookByTitle(String title);

    public List<Book> getAllBooks();

    public Book saveBook(Book book);

    public void deleteAllBooks();

    public Optional<Book> findBookById(Long id);
}
