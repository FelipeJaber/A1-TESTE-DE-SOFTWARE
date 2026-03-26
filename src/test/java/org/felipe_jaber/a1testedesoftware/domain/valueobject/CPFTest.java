package org.felipe_jaber.a1testedesoftware.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void testCpfValido() {
        CPF cpf = new CPF("12345678901");
        assertEquals("12345678901", cpf.getValue());
    }

    @Test
    void testCpfInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("123"));
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }
}
