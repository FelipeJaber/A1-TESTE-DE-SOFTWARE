package org.felipe_jaber.a1testedesoftware.web.records.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRegistrationRequest(
    @NotBlank String cpf,
    @NotBlank @Email String email,
    @NotBlank String name,
    @NotBlank String number
) {}
