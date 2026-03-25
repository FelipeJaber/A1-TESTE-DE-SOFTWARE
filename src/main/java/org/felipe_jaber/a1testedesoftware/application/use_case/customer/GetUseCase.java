package org.felipe_jaber.a1testedesoftware.application.use_case.customer;

import org.felipe_jaber.a1testedesoftware.application.exception.CustomerNotFoundException;
import org.felipe_jaber.a1testedesoftware.application.mapper.CustomerMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class GetUseCase {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public GetUseCase(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CustomerResponse execute(UUID id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        return mapper.toResponse(customer);
    }
}
