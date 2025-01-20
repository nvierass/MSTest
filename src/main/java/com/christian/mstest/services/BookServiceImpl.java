package com.christian.mstest.services;

import com.christian.mstest.model.Book;
import com.christian.mstest.repository.BookRepository;

import java.util.List;
import java.util.Optional;

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
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }
}
