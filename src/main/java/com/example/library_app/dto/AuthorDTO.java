package com.example.library_app.dto;

import com.example.library_app.entities.Book;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {


    private Long id;
    private String fullName;
    private String email;
    private Set<Book> books;
}

