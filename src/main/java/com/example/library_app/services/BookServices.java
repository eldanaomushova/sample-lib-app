package com.example.library_app.services;

import com.example.library_app.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookServices {

    Optional<BookDTO> getBookById(Long id);

    BookDTO saveBook(BookDTO newBook);

    List<BookDTO> getAllBooks();
}
