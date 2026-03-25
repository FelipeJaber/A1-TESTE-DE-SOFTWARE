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
    void shouldRegisterCustomerSuccessfully() {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("12345678901", "test@test.com", "Test Name", "11988887777");
        Customer customer = new Customer();
        CustomerResponse expectedResponse = new CustomerResponse(UUID.randomUUID(), "Test Name", "12345678901", "test@test.com", "11988887777");

        when(repository.findByCpf(any(CPF.class))).thenReturn(Optional.empty());
        when(repository.findByEmail(any(Email.class))).thenReturn(Optional.empty());
        when(mapper.toEntity(request)).thenReturn(customer);
        when(mapper.toResponse(customer)).thenReturn(expectedResponse);

        CustomerResponse result = registerUseCase.execute(request);

        assertNotNull(result);
        assertEquals(expectedResponse.id(), result.id());
        verify(repository, times(1)).save(customer);
    }

    @Test
    void shouldThrowExceptionWhenCpfAlreadyExists() {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest("12345678901", "test@test.com", "Test Name", "11988887777");

        when(repository.findByCpf(any(CPF.class))).thenReturn(Optional.of(new Customer()));

        assertThrows(CustomerAlreadyExistsException.class, () -> registerUseCase.execute(request));
        verify(repository, never()).save(any(Customer.class));
    }
}
