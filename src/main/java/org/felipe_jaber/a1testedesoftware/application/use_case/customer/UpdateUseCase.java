package org.felipe_jaber.a1testedesoftware.application.use_case.customer;

import org.felipe_jaber.a1testedesoftware.application.exception.CustomerAlreadyExistsException;
import org.felipe_jaber.a1testedesoftware.application.exception.CustomerNotFoundException;
import org.felipe_jaber.a1testedesoftware.application.mapper.CustomerMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerUpdateRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UpdateUseCase {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public UpdateUseCase(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CustomerResponse execute(UUID userId, CustomerUpdateRequest request){
        Customer customer = repository.findById(userId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        validateUniqueness(userId, request);

        mapper.updateEntityFromRequest(request, customer);
        repository.save(customer);

        return mapper.toResponse(customer);
    }

    private void validateUniqueness(UUID userId, CustomerUpdateRequest request) {
        if (request.cpf() != null && !request.cpf().isBlank()) {
            CPF cpf = new CPF(request.cpf());
            repository.findByCpf(cpf).ifPresent(existing -> {
                if (!existing.getId().equals(userId)) {
                    throw new CustomerAlreadyExistsException("Customer with CPF " + request.cpf() + " already exists");
                }
            });
        }

        if (request.email() != null && !request.email().isBlank()) {
            Email email = new Email(request.email());
            repository.findByEmail(email).ifPresent(existing -> {
                if (!existing.getId().equals(userId)) {
                    throw new CustomerAlreadyExistsException("Customer with Email " + request.email() + " already exists");
                }
            });
        }
    }
}
