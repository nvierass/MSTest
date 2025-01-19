package com.christian.mstest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "Books")
@Setter
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank (message = "Se debe indicar un título.")
    @NotEmpty (message = "Se debe indicar un título.")
    @Size (max = 200)
    private String title;

    @NotBlank (message = "Se debe indicar un autor.")
    @NotEmpty (message = "Se debe indicar un autor.")
    @Size(max = 200)
    private String author;




}
