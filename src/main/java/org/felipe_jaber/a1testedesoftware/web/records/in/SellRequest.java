package org.felipe_jaber.a1testedesoftware.web.records.in;

import java.math.BigDecimal;
import java.util.UUID;

public record SellRequest(UUID bookId, UUID customerId, UUID employeeId, Integer quantity, BigDecimal price) {
}
