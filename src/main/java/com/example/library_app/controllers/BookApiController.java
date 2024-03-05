package com.example.library_app.controllers;

import com.example.library_app.dto.BookDTO;
import com.example.library_app.entities.Book;
import com.example.library_app.entities.Publisher;
import com.example.library_app.mappers.BookMapper;
import com.example.library_app.repositories.BookRepository;
import com.example.library_app.repositories.PublisherRepository;
import com.example.library_app.services.BookServices;
import com.example.library_app.services.BookServiseJPA;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookApiController {

    private final BookServiseJPA bookService;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Resource with id:%d Not Found", id)
                ));
    }

    @DeleteMapping("{id}")
    public BookDTO deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        bookRepository.deleteById(id);
        return null;
    }
    @PutMapping("{id}")
    public ResponseEntity<Book> updateTask(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedBook.setId(id);
        return ResponseEntity.ok().body(bookRepository.save(updatedBook));
    }
    @PatchMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Book existingBook = optionalBook.get();

        if (updatedBook.getTitle() != null) {
            existingBook.setTitle(updatedBook.getTitle());
        }
        if (updatedBook.getIsbn() != null) {
            existingBook.setIsbn(updatedBook.getIsbn());
        }
        Book savedBook = bookRepository.save(existingBook);
        return ResponseEntity.ok(savedBook);
    }
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        System.out.println("before save: " + book.toString());
        return bookRepository.save(book);
    }





}