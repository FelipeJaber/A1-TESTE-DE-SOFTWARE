package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository {
    Optional<Author> findById(UUID id);
    void save(Author author);
    Page<Author> findAll(Pageable pageable);
}
