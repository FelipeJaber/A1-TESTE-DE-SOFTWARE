package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository;

import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findByCpf(String cpf);
    Optional<CustomerEntity> findByEmail(String email);
}
