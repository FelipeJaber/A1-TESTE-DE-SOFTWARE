package org.felipe_jaber.a1testedesoftware.web.records.out;

import java.util.UUID;

public record BookResponse(UUID id, String title, String isbn, AuthorResponse author) {
}
