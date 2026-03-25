package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AuthorPersistenceMapper.class})
public interface BookPersistenceMapper {
    BookEntity toEntity(Book book);
    Book toDomain(BookEntity entity);
}
