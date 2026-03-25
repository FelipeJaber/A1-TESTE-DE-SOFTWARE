package org.felipe_jaber.a1testedesoftware.web.records.out;

import java.util.UUID;

public record StockResponse(UUID id, BookResponse book, Integer quantity) {
}
