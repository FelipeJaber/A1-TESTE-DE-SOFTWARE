package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Sell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface SellRepository {
    Optional<Sell> findById(UUID id);
    void save(Sell sell);
    Page<Sell> findAll(Pageable pageable);
}
