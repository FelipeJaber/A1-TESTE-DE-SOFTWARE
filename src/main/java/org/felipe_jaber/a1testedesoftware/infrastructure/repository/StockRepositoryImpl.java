package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.domain.entity.Stock;
import org.felipe_jaber.a1testedesoftware.domain.repository.StockRepository;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.BookPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.StockPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaStockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class StockRepositoryImpl implements StockRepository {
    private final JpaStockRepository jpaRepository;
    private final StockPersistenceMapper mapper;
    private final BookPersistenceMapper bookMapper;

    public StockRepositoryImpl(JpaStockRepository jpaRepository, StockPersistenceMapper mapper, BookPersistenceMapper bookMapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<Stock> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void save(Stock stock) {
        jpaRepository.save(mapper.toEntity(stock));
    }

    @Override
    public Page<Stock> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Optional<Stock> findByBook(Book book) {
        return jpaRepository.findByBook(bookMapper.toEntity(book)).map(mapper::toDomain);
    }
}
