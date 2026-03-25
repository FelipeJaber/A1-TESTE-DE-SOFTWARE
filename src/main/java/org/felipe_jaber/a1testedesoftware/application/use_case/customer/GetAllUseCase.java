package org.felipe_jaber.a1testedesoftware.application.use_case.customer;

import org.felipe_jaber.a1testedesoftware.application.mapper.CustomerMapper;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetAllUseCase {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public GetAllUseCase(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<CustomerResponse> execute(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }
}
