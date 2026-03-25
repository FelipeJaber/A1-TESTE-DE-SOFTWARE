package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorPersistenceMapper {
    AuthorEntity toEntity(Author author);
    Author toDomain(AuthorEntity entity);
}
