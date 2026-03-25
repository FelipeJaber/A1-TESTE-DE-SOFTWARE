package org.felipe_jaber.a1testedesoftware.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateEmailWhenValueIsValid() {
        String validEmail = "test@example.com";
        Email email = new Email(validEmail);
        assertEquals(validEmail, email.getValue());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        String invalidEmail = "invalid-email";
        assertThrows(IllegalArgumentException.class, () -> new Email(invalidEmail));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void shouldReturnTrueForValidEmailStrings() {
        assertTrue(Email.isValid("user@domain.com"));
        assertTrue(Email.isValid("user.name+tag@domain.co.uk"));
    }

    @Test
    void shouldReturnFalseForInvalidEmailStrings() {
        assertFalse(Email.isValid("plainaddress"));
        assertFalse(Email.isValid("@missinguser.com"));
        assertFalse(Email.isValid("user@.com"));
    }
}
