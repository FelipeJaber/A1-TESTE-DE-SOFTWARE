package org.felipe_jaber.a1testedesoftware.web.records.in;

import java.util.UUID;

public record BookRequest(String title, String isbn, UUID authorId) {
}
