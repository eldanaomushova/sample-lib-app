package com.example.library_app.services;

import com.example.library_app.dto.BookDTO;
import com.example.library_app.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@Component
@SpringBootTest

class BookServiceJPATest {
    @Autowired
    private BookServiseJPA bookServiceJPA;

    @Test
    void convertEntityToDTO() {
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("5134454")
                .build();

        BookDTO dto = bookServiceJPA.convertEntityToDTO(book);

        assertNotNull(dto);
        assertEquals(12L,dto.getId());
        assertEquals("Test book", dto.getTitle());
        assertEquals("5134454", dto.getIsbn());
    }
}
