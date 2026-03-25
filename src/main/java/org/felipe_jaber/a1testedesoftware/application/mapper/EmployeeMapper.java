package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Employee;
import org.felipe_jaber.a1testedesoftware.web.records.in.EmployeeRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeResponse toResponse(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeRequest request);
}
