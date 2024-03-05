package com.example.library_app.bootstrap;

import com.example.library_app.entities.Author;
import com.example.library_app.entities.Book;
import com.example.library_app.entities.Publisher;
import com.example.library_app.repositories.AuthorRepository;
import com.example.library_app.repositories.BookRepository;
import com.example.library_app.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2 //object log
@RequiredArgsConstructor //contructor by himself
public class InitData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;


    @Override
    public void run(String... args) throws Exception {
        log.atWarn().log("Initializing data");
        Book book1 = Book.builder()
                .title("Database")
                .publishedYear(2018)
                .isbn("151345-13151")
                .build();

        Book book2 = Book.builder()
                .title("Pro Spring 6")
                .publishedYear(2023)
                .isbn("454354314354")
                .edition(6)
                .build();

        bookRepository.saveAll(List.of(book1, book2));
        Publisher publisher1 = Publisher.builder()
                .name("Lev Tolstoy")
                .email("tolstoy@gmail.com")
                .build();
        Publisher publisher2 = Publisher.builder()
                .name("Pushkin")
                .email("pushkin@gmail.com")
                .build();
        Publisher publisher3 = Publisher.builder()
                .name("Agata")
                .email("agata@gmail.com")
                .build();
        publisherRepository.saveAll(List.of(publisher1, publisher2, publisher3));
        Author author1 = Author.builder()
                .fullName("Tigr Hudoi")
                .email("tigrhudoi@gmail.com")
                .build();
        Author author2 = Author.builder()
                .fullName("Kim Taehyung")
                .email("taehyung@gmail.com")
                .build();
        authorRepository.saveAll(List.of(author1, author2));
    }
}
