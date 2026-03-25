package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.repository.CustomerRepository;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.CustomerPersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaCustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerRepository jpaRepository;
    private final CustomerPersistenceMapper mapper;

    public CustomerRepositoryImpl(JpaCustomerRepository jpaRepository, CustomerPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Customer> findById(UUID userId) {
        return jpaRepository.findById(userId).map(mapper::toDomain);
    }

    @Override
    public void save(Customer customer) {
        jpaRepository.save(mapper.toEntity(customer));
    }

    @Override
    public Optional<Customer> findByCpf(CPF cpf) {
        return jpaRepository.findByCpf(cpf.getValue()).map(mapper::toDomain);
    }

    @Override
    public Optional<Customer> findByEmail(Email email) {
        return jpaRepository.findByEmail(email.getValue()).map(mapper::toDomain);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }
}
