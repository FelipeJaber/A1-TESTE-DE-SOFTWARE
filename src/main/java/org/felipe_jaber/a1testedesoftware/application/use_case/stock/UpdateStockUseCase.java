package org.felipe_jaber.a1testedesoftware.application.use_case.stock;

import org.felipe_jaber.a1testedesoftware.application.mapper.StockMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Book;
import org.felipe_jaber.a1testedesoftware.domain.entity.Stock;
import org.felipe_jaber.a1testedesoftware.domain.repository.BookRepository;
import org.felipe_jaber.a1testedesoftware.domain.repository.StockRepository;
import org.felipe_jaber.a1testedesoftware.web.records.in.StockRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.StockResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UpdateStockUseCase {
    private final StockRepository repository;
    private final BookRepository bookRepository;
    private final StockMapper mapper;

    public UpdateStockUseCase(StockRepository repository, BookRepository bookRepository, StockMapper mapper) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public StockResponse execute(StockRequest request) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Stock stock = repository.findByBook(book)
                .orElseGet(() -> {
                    Stock newStock = new Stock();
                    newStock.setId(UUID.randomUUID());
                    newStock.setBook(book);
                    newStock.setQuantity(0);
                    return newStock;
                });

        stock.setQuantity(stock.getQuantity() + request.quantity());
        repository.save(stock);

        return mapper.toResponse(stock);
    }
}
