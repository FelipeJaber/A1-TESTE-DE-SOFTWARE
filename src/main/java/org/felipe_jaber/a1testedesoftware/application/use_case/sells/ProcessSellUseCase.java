package org.felipe_jaber.a1testedesoftware.application.use_case.sells;

import org.felipe_jaber.a1testedesoftware.application.mapper.SellMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.*;
import org.felipe_jaber.a1testedesoftware.domain.repository.*;
import org.felipe_jaber.a1testedesoftware.web.records.in.SellRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.SellResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class ProcessSellUseCase {
    private final SellRepository repository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final StockRepository stockRepository;
    private final SellMapper mapper;

    public ProcessSellUseCase(
            SellRepository repository,
            BookRepository bookRepository,
            CustomerRepository customerRepository,
            EmployeeRepository employeeRepository,
            StockRepository stockRepository,
            SellMapper mapper
    ) {
        this.repository = repository;
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
        this.stockRepository = stockRepository;
        this.mapper = mapper;
    }

    public SellResponse execute(SellRequest request) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Employee employee = employeeRepository.findById(request.employeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Stock stock = stockRepository.findByBook(book)
                .orElseThrow(() -> new RuntimeException("Stock not found for book"));

        if (stock.getQuantity() < request.quantity()) {
            throw new RuntimeException("Insufficient stock");
        }

        stock.setQuantity(stock.getQuantity() - request.quantity());
        stockRepository.save(stock);

        Sell sell = mapper.toEntity(request);
        sell.setId(UUID.randomUUID());
        sell.setBook(book);
        sell.setCustomer(customer);
        sell.setEmployee(employee);
        sell.setSellDate(LocalDateTime.now());

        repository.save(sell);

        return mapper.toResponse(sell);
    }
}
