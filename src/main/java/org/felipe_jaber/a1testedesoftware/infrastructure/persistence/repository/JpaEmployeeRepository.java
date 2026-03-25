package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository;

import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaEmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
    Optional<EmployeeEntity> findByRegistration(String registration);
}
