package org.felipe_jaber.a1testedesoftware.application.use_case.sells;

import org.felipe_jaber.a1testedesoftware.application.mapper.SellMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.*;
import org.felipe_jaber.a1testedesoftware.domain.repository.*;
import org.felipe_jaber.a1testedesoftware.web.records.in.SellRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.BookResponse;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.felipe_jaber.a1testedesoftware.web.records.out.EmployeeResponse;
import org.felipe_jaber.a1testedesoftware.web.records.out.SellResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProcessSellUseCaseTest {

    @Mock
    private SellRepository repository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private StockRepository stockRepository;
    @Mock
    private SellMapper mapper;

    @InjectMocks
    private ProcessSellUseCase processSellUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessarVendaSucesso() {
        SellRequest request = new SellRequest(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 2, new BigDecimal("100.00"));
        Stock stock = new Stock();
        stock.setQuantity(10);

        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book()));
        when(customerRepository.findById(any())).thenReturn(Optional.of(new Customer()));
        when(employeeRepository.findById(any())).thenReturn(Optional.of(new Employee()));
        when(stockRepository.findByBook(any())).thenReturn(Optional.of(stock));
        when(mapper.toEntity(any())).thenReturn(new Sell());
        when(mapper.toResponse(any())).thenReturn(mock(SellResponse.class));

        assertNotNull(processSellUseCase.execute(request));
        assertEquals(8, stock.getQuantity());
    }

    @Test
    void testVendaErroEstoqueInsuficiente() {
        SellRequest request = new SellRequest(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 10, new BigDecimal("100.00"));
        Stock stock = new Stock();
        stock.setQuantity(5);

        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book()));
        when(customerRepository.findById(any())).thenReturn(Optional.of(new Customer()));
        when(employeeRepository.findById(any())).thenReturn(Optional.of(new Employee()));
        when(stockRepository.findByBook(any())).thenReturn(Optional.of(stock));

        RuntimeException error = assertThrows(RuntimeException.class, () -> processSellUseCase.execute(request));
        assertEquals("Insufficient stock", error.getMessage());
    }
}
