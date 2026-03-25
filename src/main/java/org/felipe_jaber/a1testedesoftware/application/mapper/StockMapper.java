package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Stock;
import org.felipe_jaber.a1testedesoftware.web.records.in.StockRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.StockResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface StockMapper {
    StockResponse toResponse(Stock stock);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    Stock toEntity(StockRequest request);
}
