package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Employee;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeePersistenceMapper {
    EmployeeEntity toEntity(Employee employee);
    Employee toDomain(EmployeeEntity entity);
}
