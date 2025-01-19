package com.christian.mstest.services;

import com.christian.mstest.model.Book;

import java.util.List;


public interface BookService {
    //public Book getBookByTitle(String title);

    public List<Book> getAllBooks();

    public Book saveBook(Book book);
}
