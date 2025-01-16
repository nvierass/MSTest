package com.christian.mstest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Books")
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String author;

    public Book(){}
}
