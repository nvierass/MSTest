package com.christian.mstest.services;

import com.christian.mstest.model.Book;
import com.christian.mstest.repository.BookRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*
    @Override
    public Book getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        if (book != null) {
            BookResponse bookResponse = new BookResponse(book.getTitle(), book.getAuthor());
            return ResponseEntity.ok(bookResponse);
        }
        return ResponseEntity.noContent().build();
    }*/

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

}
