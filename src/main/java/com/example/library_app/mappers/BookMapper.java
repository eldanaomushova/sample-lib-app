package com.example.library_app.mappers;



@Mapper
public interface BookMapper {

    @Mapping(target = "authors", ignore = true)
    @Mapping(source = "name", target = "title")
    @Mapping(target = "publisher.books", ignore = true)
    Book bookDtoToBook(BookDTO dto);

    @InheritInverseConfiguration
    @Mapping(target = "publisher.books", ignore = true)
    BookDTO bookToBookDto(Book book);


}