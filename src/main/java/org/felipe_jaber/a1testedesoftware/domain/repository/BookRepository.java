package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository {
    Optional<Book> findById(UUID id);
    void save(Book book);
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findByIsbn(String isbn);
}
