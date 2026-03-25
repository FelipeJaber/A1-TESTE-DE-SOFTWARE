package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository;

import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.BookEntity;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaStockRepository extends JpaRepository<StockEntity, UUID> {
    Optional<StockEntity> findByBook(BookEntity book);
}
