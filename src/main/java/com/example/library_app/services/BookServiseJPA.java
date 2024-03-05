package com.example.library_app.services;

import com.example.library_app.dto.BookDTO;
import com.example.library_app.entities.Book;
import com.example.library_app.mappers.BookMapper;
import com.example.library_app.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiseJPA implements BookServices {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookDTO convertEntityToDTO(Book book) {
        return bookMapper.bookToBookDto(book);
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return Optional.ofNullable(
                bookMapper.bookToBookDto(
                        bookRepository.findById(id)
                                .orElse(null)
                )
        );
    }
    @Override
    public BookDTO saveBook(BookDTO newBook) {
        return bookMapper
                .bookToBookDto(
                        bookRepository.save(bookMapper.bookDtoToBook(newBook))
                );
    }
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
