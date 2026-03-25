package org.felipe_jaber.a1testedesoftware.domain.valueobject;

import java.util.regex.Pattern;

public class Email {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private final String value;

    public Email(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String email) {
        if (email == null || email.isBlank()) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    @Override
    public String toString() {
        return value;
    }
}