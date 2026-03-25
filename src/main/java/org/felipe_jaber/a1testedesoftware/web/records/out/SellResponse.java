package org.felipe_jaber.a1testedesoftware.web.records.out;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record SellResponse(
        UUID id,
        BookResponse book,
        CustomerResponse customer,
        EmployeeResponse employee,
        Integer quantity,
        BigDecimal price,
        LocalDateTime sellDate
) {
}
