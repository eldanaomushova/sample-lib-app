package com.example.library_app.mappers;

import com.example.library_app.dto.BookDTO;
import com.example.library_app.dto.PublisherDTO;
import com.example.library_app.entities.Book;
import com.example.library_app.entities.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;


import static org.junit.jupiter.api.Assertions.*;
@Component
@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void bookToBookDto() {
        Publisher build = Publisher.builder().build();
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        BookDTO dto = bookMapper.bookToBookDTO(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
    }

    @Test
    void bookDtoToBook() {
        BookDTO dto = BookDTO.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        Book book = bookMapper.bookDtoToBook(dto);

        assertNotNull(book);
        assertEquals(12L,book.getId());
        assertEquals("Test book", book.getTitle());
        assertEquals("5134454", book.getIsbn());

    }
}