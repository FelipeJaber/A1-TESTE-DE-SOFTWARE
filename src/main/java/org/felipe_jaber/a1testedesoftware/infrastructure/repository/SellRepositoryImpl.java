package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Sell;
import org.felipe_jaber.a1testedesoftware.domain.repository.SellRepository;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.SellPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaSellRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SellRepositoryImpl implements SellRepository {
    private final JpaSellRepository jpaRepository;
    private final SellPersistenceMapper mapper;

    public SellRepositoryImpl(JpaSellRepository jpaRepository, SellPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Sell> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void save(Sell sell) {
        jpaRepository.save(mapper.toEntity(sell));
    }

    @Override
    public Page<Sell> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }
}
