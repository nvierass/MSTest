package com.christian.mstest.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO {

    @NotBlank (message = "Se debe indicar un título.")
    @NotEmpty (message = "Se debe indicar un título.")
    @Size (max = 200)
    private String title;

    @NotBlank (message = "Se debe indicar un autor.")
    @NotEmpty (message = "Se debe indicar un autor.")
    @Size(max = 200)
    private String author;

}
