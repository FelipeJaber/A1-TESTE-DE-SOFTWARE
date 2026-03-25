package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findById(UUID userId);

    void save(Customer updatedCustomer);

    Optional<Customer> findByCpf(CPF cpf);

    Optional<Customer> findByEmail(Email email);

    Page<Customer> findAll(Pageable pageable);
}
