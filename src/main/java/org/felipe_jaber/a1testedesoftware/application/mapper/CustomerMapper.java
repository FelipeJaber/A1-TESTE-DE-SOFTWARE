package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.PhoneNumber;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerRegistrationRequest;
import org.felipe_jaber.a1testedesoftware.web.records.in.CustomerUpdateRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.CustomerResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", imports = {CPF.class, Email.class, PhoneNumber.class})
public interface CustomerMapper {
    CustomerResponse toResponse(Customer updatedCustomer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", expression = "java(new CPF(request.cpf()))")
    @Mapping(target = "email", expression = "java(new Email(request.email()))")
    @Mapping(target = "number", expression = "java(new PhoneNumber(request.number()))")
    Customer toEntity(CustomerRegistrationRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", source = "cpf", qualifiedByName = "mapCpf")
    @Mapping(target = "email", source = "email", qualifiedByName = "mapEmail")
    @Mapping(target = "number", source = "number", qualifiedByName = "mapPhoneNumber")
    void updateEntityFromRequest(CustomerUpdateRequest request, @MappingTarget Customer customer);

    default String map(CPF cpf) {
        return cpf != null ? cpf.getValue() : null;
    }

    default String map(Email email) {
        return email != null ? email.getValue() : null;
    }

    default String map(PhoneNumber number) {
        return number != null ? number.getValue() : null;
    }

    @org.mapstruct.Named("mapCpf")
    default CPF mapCpf(String value) {
        return (value != null && !value.isBlank()) ? new CPF(value) : null;
    }

    @org.mapstruct.Named("mapEmail")
    default Email mapEmail(String value) {
        return (value != null && !value.isBlank()) ? new Email(value) : null;
    }

    @org.mapstruct.Named("mapPhoneNumber")
    default PhoneNumber mapPhoneNumber(String value) {
        return (value != null && !value.isBlank()) ? new PhoneNumber(value) : null;
    }
}
