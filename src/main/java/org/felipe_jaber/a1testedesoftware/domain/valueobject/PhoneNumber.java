package org.felipe_jaber.a1testedesoftware.domain.valueobject;

public class PhoneNumber {

    private final String value;

    public PhoneNumber(String raw) {
        String normalized = normalize(raw);

        if (!isValid(normalized)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.value = format(normalized);
    }

    public String getValue() {
        return value;
    }

    private static String normalize(String input) {
        if (input == null) return null;

        String numbers = input.replaceAll("\\D", "");

        if (numbers.startsWith("0")) {
            numbers = numbers.substring(1);
        }

        return numbers;
    }

    public static boolean isValid(String number) {
        if (number == null) return false;

        return number.length() == 10 || number.length() == 11;
    }

    private static String format(String number) {
        if (number.length() == 11) {
            return String.format("(%s) %s-%s",
                    number.substring(0, 2),
                    number.substring(2, 7),
                    number.substring(7));
        } else {
            return String.format("(%s) %s-%s",
                    number.substring(0, 2),
                    number.substring(2, 6),
                    number.substring(6));
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
