package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Author;
import org.felipe_jaber.a1testedesoftware.domain.repository.AuthorRepository;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.AuthorPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaAuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private final JpaAuthorRepository jpaRepository;
    private final AuthorPersistenceMapper mapper;

    public AuthorRepositoryImpl(JpaAuthorRepository jpaRepository, AuthorPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void save(Author author) {
        jpaRepository.save(mapper.toEntity(author));
    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }
}
