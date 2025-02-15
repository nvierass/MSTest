package com.christian.mstest.controller;

import com.christian.mstest.controller.response.BookResponse;
import com.christian.mstest.model.Book;
import com.christian.mstest.services.BookService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookControllerApi{

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        List<BookResponse> bookResponses = books.stream()
            .map(book -> new BookResponse(book.getTitle(), book.getAuthor()))
            .collect(Collectors.toList());
        return new ResponseEntity<List<BookResponse>>(bookResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookResponse> createBook(@RequestBody Book book){
        Book createdBook = bookService.saveBook(book);
        BookResponse bookResponse = new BookResponse(createdBook.getTitle(), createdBook.getAuthor());
        return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        String message = "Se han eliminado todos los libros.";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookResponse> getBook(Long id){
        Optional<Book> optionalBook = bookService.findBookById(id);
        if (optionalBook.isPresent()){
            Book book = optionalBook.get();
            BookResponse bookResponse = new BookResponse(book.getTitle(), book.getAuthor());
            return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /*
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
    }*/
}