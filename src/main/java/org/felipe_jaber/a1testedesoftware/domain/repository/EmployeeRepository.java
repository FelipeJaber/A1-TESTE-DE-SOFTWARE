package org.felipe_jaber.a1testedesoftware.domain.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository {
    Optional<Employee> findById(UUID id);
    void save(Employee employee);
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findByRegistration(String registration);
}
