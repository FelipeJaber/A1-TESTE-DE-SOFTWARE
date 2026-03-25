package org.felipe_jaber.a1testedesoftware.infrastructure.repository;

import org.felipe_jaber.a1testedesoftware.domain.entity.Employee;
import org.felipe_jaber.a1testedesoftware.domain.repository.EmployeeRepository;
import org.felipe_jaber.a1testedesoftware.infrastructure.mapper.EmployeePersistenceMapper;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.repository.JpaEmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final JpaEmployeeRepository jpaRepository;
    private final EmployeePersistenceMapper mapper;

    public EmployeeRepositoryImpl(JpaEmployeeRepository jpaRepository, EmployeePersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void save(Employee employee) {
        jpaRepository.save(mapper.toEntity(employee));
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Optional<Employee> findByRegistration(String registration) {
        return jpaRepository.findByRegistration(registration).map(mapper::toDomain);
    }
}
