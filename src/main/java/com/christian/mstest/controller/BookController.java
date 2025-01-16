package com.christian.mstest.controller;

import com.christian.mstest.controller.response.BookResponse;
import com.christian.mstest.model.Book;
import com.christian.mstest.repository.BookRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookControllerApi{

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepositor) {
        this.bookRepository = bookRepositor;
    }

    @Override
    public ResponseEntity<BookResponse> getBookById(
            @Validated 
            @NotNull(message = "Debe especificar un ID")
            @Size(max = 10, message = "El ID no debe superar los 10 caracteres") 
            @RequestParam Long id) {
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            return ResponseEntity.status(HttpStatus.OK).body(new BookResponse(book.getTitle(), book.getAuthor()));
        }
        return new ResponseEntity<BookResponse>(HttpStatus.NOT_IMPLEMENTED);
    } 
}