package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.domain.repository.BookRepository;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.BookPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final JpaBookRepository jpaRepository;
    private final BookPersistenceMapper mapper;

    public BookRepositoryImpl(JpaBookRepository jpaRepository, BookPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void save(Book book) {
        jpaRepository.save(mapper.toEntity(book));
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return jpaRepository.findByIsbn(isbn).map(mapper::toDomain);
    }
}
