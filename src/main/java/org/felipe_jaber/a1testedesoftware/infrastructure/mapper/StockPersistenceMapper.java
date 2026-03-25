package org.felipe_jaber.a1testedesoftware.infrastructure.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Stock;
import org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity.StockEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BookPersistenceMapper.class})
public interface StockPersistenceMapper {
    StockEntity toEntity(Stock stock);
    Stock toDomain(StockEntity entity);
}
