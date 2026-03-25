package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.web.records.in.BookRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {
    BookResponse toResponse(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book toEntity(BookRequest request);
}
