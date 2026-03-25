package org.felipe_jaber.a1testedesoftware.application.mapper;

import org.felipe_jaber.a1testedesoftware.domain.entity.Sell;
import org.felipe_jaber.a1testedesoftware.web.records.in.SellRequest;
import org.felipe_jaber.a1testedesoftware.web.records.out.SellResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class, CustomerMapper.class, EmployeeMapper.class})
public interface SellMapper {
    SellResponse toResponse(Sell sell);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "sellDate", ignore = true)
    Sell toEntity(SellRequest request);
}
