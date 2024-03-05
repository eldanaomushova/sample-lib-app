package com.example.library_app.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    @Builder.Default
    private int edition = 1;
    private PublisherDTO publisherDTO;
}
