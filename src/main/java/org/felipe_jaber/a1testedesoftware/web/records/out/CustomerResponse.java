package org.felipe_jaber.a1testedesoftware.web.records.out;

import java.util.UUID;

public record CustomerResponse(UUID id, String name, String cpf, String email, String number) {
}
