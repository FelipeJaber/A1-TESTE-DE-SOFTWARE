package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.felipe_jaber.a1testedesoftware.web.records.in.AuthorRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toResponse(Author author);

    @Mapping(target = "id", ignore = true)
    Author toEntity(AuthorRequest request);
}
