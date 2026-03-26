package org.felipe_jaber.a1testedesoftware.application.use_case.customer;

import org.felipe_jaber.a1testedesoftware.application.exception.CustomerAlreadyExistsException;
import org.felipe_jaber.a1testedesoftware.application.mapper.CustomerMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerRegistrationRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegisterUseCaseTest {

    @Mock
    private CustomerRepository repository;

    @Mock
    private CustomerMapper mapper;

    @InjectMocks
    private RegisterUseCase registerUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarClienteSucesso() {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("12345678901", "test@test.com", "Joao", "11988887777");
        Customer customer = new Customer();
        CustomerResponse response = new CustomerResponse(UUID.randomUUID(), "Joao", "12345678901", "test@test.com", "11988887777");

        when(repository.findByCpf(any())).thenReturn(Optional.empty());
        when(repository.findByEmail(any())).thenReturn(Optional.empty());
        when(mapper.toEntity(any())).thenReturn(customer);
        when(mapper.toResponse(any())).thenReturn(response);

        assertNotNull(registerUseCase.execute(request));
        verify(repository).save(customer);
    }

    @Test
    void testRegistrarClienteErroDuplicado() {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("12345678901", "test@test.com", "Joao", "11988887777");
        when(repository.findByCpf(any())).thenReturn(Optional.of(new Customer()));

        assertThrows(CustomerAlreadyExistsException.class, () -> registerUseCase.execute(request));
    }
}
