package com.christian.mstest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.christian.mstest.controller.response.BookResponse;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RequestMapping("/v1/books")
public interface BookControllerApi {
    
    @GetMapping
    public default ResponseEntity<BookResponse> getBookById(
            @Validated 
            @NotNull(message = "Debe especificar un ID")
            @Size(max = 10, message = "El ID no debe superar los 10 caracteres") 
            @RequestParam Long id) {
        return new ResponseEntity<BookResponse>(HttpStatus.NOT_IMPLEMENTED);
    } 
}  
