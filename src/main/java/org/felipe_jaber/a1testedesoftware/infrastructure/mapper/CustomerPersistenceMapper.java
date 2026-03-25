package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Customer;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.PhoneNumber;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {CPF.class, Email.class, PhoneNumber.class})
public interface CustomerPersistenceMapper {

    @Mapping(target = "cpf", source = "cpf.value")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "number", source = "number.value")
    CustomerEntity toEntity(Customer customer);

    @Mapping(target = "cpf", expression = "java(new CPF(entity.getCpf()))")
    @Mapping(target = "email", expression = "java(new Email(entity.getEmail()))")
    @Mapping(target = "number", expression = "java(new PhoneNumber(entity.getNumber()))")
    Customer toDomain(CustomerEntity entity);

    default String map(CPF cpf) {
        return cpf != null ? cpf.getValue() : null;
    }

    default String map(Email email) {
        return email != null ? email.getValue() : null;
    }

    default String map(PhoneNumber number) {
        return number != null ? number.getValue() : null;
    }

    default CPF mapCpf(String value) {
        return value != null ? new CPF(value) : null;
    }

    default Email mapEmail(String value) {
        return value != null ? new Email(value) : null;
    }

    default PhoneNumber mapPhoneNumber(String value) {
        return value != null ? new PhoneNumber(value) : null;
    }
}
