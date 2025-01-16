package com.christian.mstest.services;

import com.christian.mstest.controller.response.BookResponse;
import com.christian.mstest.model.Book;
import com.christian.mstest.repository.BookRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<BookResponse> getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        //if (book != null) {
        //    BookResponse bookResponse = new BookResponse();
        //    bookResponse.setTitle(book.getTitle());
        //    bookResponse.setAuthor(book.getAuthor());
        //    return ResponseEntity.ok(bookResponse);
        //}
        return ResponseEntity.noContent().build();
    }

    public void method(){}
}
