package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Sell;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.SellEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookPersistenceMapper.class, CustomerPersistenceMapper.class, EmployeePersistenceMapper.class})
public interface SellPersistenceMapper {
    SellEntity toEntity(Sell sell);
    Sell toDomain(SellEntity entity);
}
