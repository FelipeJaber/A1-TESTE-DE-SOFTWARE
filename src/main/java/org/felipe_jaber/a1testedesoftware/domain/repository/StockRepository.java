package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.domain.entity.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface StockRepository {
    Optional<Stock> findById(UUID id);
    void save(Stock stock);
    Page<Stock> findAll(Pageable pageable);
    Optional<Stock> findByBook(Book book);
}
