package org.felipe_jaber.a1testedesoftware.application.use_case.customer;

import org.felipe_jaber.a1testedesoftware.application.exception.CustomerAlreadyExistsException;
import org.felipe_jaber.a1testedesoftware.application.mapper.CustomerMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerRegistrationRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class RegisterUseCase {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public RegisterUseCase(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CustomerResponse execute(CustomerRegistrationRequest request) {
        validateExistence(request);

        Customer customer = mapper.toEntity(request);
        customer.setId(UUID.randomUUID());
        repository.save(customer);

        return mapper.toResponse(customer);
    }

    private void validateExistence(CustomerRegistrationRequest request) {
        CPF cpf = new CPF(request.cpf());
        if (repository.findByCpf(cpf).isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with CPF " + request.cpf() + " already exists");
        }

        Email email = new Email(request.email());
        if (repository.findByEmail(email).isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with Email " + request.email() + " already exists");
        }
    }
}
