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
    void shouldProcessSellSuccessfully() {
        UUID bookId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        UUID employeeId = UUID.randomUUID();
        SellRequest request = new SellRequest(bookId, customerId, employeeId, 2, new BigDecimal("100.00"));

        Book book = new Book();
        Customer customer = new Customer();
        Employee employee = new Employee();
        Stock stock = new Stock();
        stock.setQuantity(10);
        Sell sell = new Sell();

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
        when(stockRepository.findByBook(book)).thenReturn(Optional.of(stock));
        when(mapper.toEntity(request)).thenReturn(sell);
        when(mapper.toResponse(any(Sell.class))).thenReturn(new SellResponse(UUID.randomUUID(), mock(BookResponse.class), mock(CustomerResponse.class), mock(EmployeeResponse.class), 2, new BigDecimal("100.00"), LocalDateTime.now()));

        SellResponse response = processSellUseCase.execute(request);

        assertNotNull(response);
        assertEquals(8, stock.getQuantity());
        verify(stockRepository, times(1)).save(stock);
        verify(repository, times(1)).save(sell);
    }

    @Test
    void shouldThrowExceptionWhenStockIsInsufficient() {
        UUID bookId = UUID.randomUUID();
        SellRequest request = new SellRequest(bookId, UUID.randomUUID(), UUID.randomUUID(), 10, new BigDecimal("100.00"));

        Book book = new Book();
        Stock stock = new Stock();
        stock.setQuantity(5);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(customerRepository.findById(any())).thenReturn(Optional.of(new Customer()));
        when(employeeRepository.findById(any())).thenReturn(Optional.of(new Employee()));
        when(stockRepository.findByBook(book)).thenReturn(Optional.of(stock));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> processSellUseCase.execute(request));
        assertEquals("Insufficient stock", exception.getMessage());
        verify(repository, never()).save(any());
    }
}
