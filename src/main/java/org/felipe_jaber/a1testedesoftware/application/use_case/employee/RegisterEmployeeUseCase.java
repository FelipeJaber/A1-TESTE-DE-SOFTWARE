package org.felipe_jaber.a1testedesoftware.application.use_case.employee;

import org.felipe_jaber.a1testedesoftware.application.mapper.EmployeeMapper;
import org.felipe_jaber.a1testedesoftware.domain.entity.Employee;
import org.felipe_jaber.a1testedesoftware.domain.repository.EmployeeRepository;
import org.felipe_jaber.a1testedesoftware.web.records.in.EmployeeRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.EmployeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class RegisterEmployeeUseCase {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public RegisterEmployeeUseCase(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EmployeeResponse execute(EmployeeRequest request) {
        if (repository.findByRegistration(request.registration()).isPresent()) {
            throw new RuntimeException("Employee already exists");
        }
        Employee employee = mapper.toEntity(request);
        employee.setId(UUID.randomUUID());
        repository.save(employee);
        return mapper.toResponse(employee);
    }
}
