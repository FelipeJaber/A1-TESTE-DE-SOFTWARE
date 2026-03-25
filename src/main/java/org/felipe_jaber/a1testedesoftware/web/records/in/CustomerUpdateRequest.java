package org.felipe_jaber.a1testedesoftware.web.records.in;

import jakarta.validation.constraints.Email;

public record CustomerUpdateRequest(String cpf, @Email String email, String name, String number) {
}
