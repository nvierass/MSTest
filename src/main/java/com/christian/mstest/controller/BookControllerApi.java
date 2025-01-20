package com.christian.mstest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.christian.mstest.controller.request.BookDTO;
import com.christian.mstest.controller.response.BookResponse;
import com.christian.mstest.model.Book;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RequestMapping("/v1/books")
public interface BookControllerApi {
    
    /*
    @GetMapping
    public default ResponseEntity<BookResponse> getBookById(
            @Validated 
            @NotNull(message = "Debe especificar un ID")
            @Size(max = 10, message = "El ID no debe superar los 10 caracteres") 
            @RequestParam Long id) {
        return new ResponseEntity<BookResponse>(HttpStatus.NOT_IMPLEMENTED);
    } */

    @GetMapping
    public default ResponseEntity<List<BookResponse>> getAllBooks(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping
    public default ResponseEntity<BookResponse> createBook(@Valid @RequestBody Book book){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping
    public default ResponseEntity<BookResponse> updateBooks(){
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping
    public default ResponseEntity<String> deleteAllBooks(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    public default ResponseEntity<BookResponse> getBook(@PathVariable() @Validated Long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/{id}")
    public default ResponseEntity<BookResponse> createBook(){
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/{id}")
    public default ResponseEntity<BookResponse> updateBook(@RequestBody Book updatedBook){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    public default ResponseEntity<String> deleteBook(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}  
