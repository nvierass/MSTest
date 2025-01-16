package com.christian.mstest.services;

import com.christian.mstest.controller.response.BookResponse;
import org.springframework.http.ResponseEntity;

public interface BookService {
    public ResponseEntity<BookResponse> getBookByTitle(String title);
}
