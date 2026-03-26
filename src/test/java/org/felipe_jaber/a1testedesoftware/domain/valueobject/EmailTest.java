package org.felipe_jaber.a1testedesoftware.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testEmailValido() {
        Email email = new Email("test@example.com");
        assertEquals("test@example.com", email.getValue());
        assertTrue(Email.isValid("user@domain.com"));
    }

    @Test
    void testEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email("invalido"));
        assertFalse(Email.isValid("sem-arroba"));
        assertFalse(Email.isValid(null));
    }
}
