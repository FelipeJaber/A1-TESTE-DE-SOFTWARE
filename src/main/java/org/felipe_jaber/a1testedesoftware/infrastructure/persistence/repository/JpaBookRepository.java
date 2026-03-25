package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository;

import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaBookRepository extends JpaRepository<BookEntity, UUID> {
    Optional<BookEntity> findByIsbn(String isbn);
}
