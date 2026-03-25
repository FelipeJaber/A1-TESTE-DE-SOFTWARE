package org.felipe_jaber.a1testedesoftware.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldCreateCpfWhenValueIsValid() {
        String validCpf = "12345678901";
        CPF cpf = new CPF(validCpf);
        assertEquals(validCpf, cpf.getValue());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsInvalid() {
        String invalidCpf = "123";
        assertThrows(IllegalArgumentException.class, () -> new CPF(invalidCpf));
    }

    @Test
    void shouldThrowExceptionWhenCpfIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }
}
