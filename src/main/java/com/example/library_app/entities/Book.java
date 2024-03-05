package com.example.library_app.entities;

import com.example.library_app.entities.Author;
import com.example.library_app.entities.Publisher;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NonNull private String title;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private long id;

    private String isbn;
    private int publishedYear;

    @Builder.Default
    private int edition = 1;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;
}
