package com.example.library_app.mappers;


import com.example.library_app.dto.BookDTO;
import com.example.library_app.entities.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "publisher.books", ignore = true)
    Book bookDtoToBook(BookDTO dto);

    @InheritInverseConfiguration
    @Mapping(target = "publisher.books", ignore = true)
    BookDTO bookToBookDto(Book book);


}