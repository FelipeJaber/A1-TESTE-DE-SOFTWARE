package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository;

import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAuthorRepository extends JpaRepository<AuthorEntity, UUID> {
}
