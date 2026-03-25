package org.felipe_jaber.a1testedesoftware.domain.valueobject;

public class CPF {

    private final String value;

    public CPF(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.value = value;
    }

    private boolean isValid(String cpf) {
        return cpf != null && cpf.length() == 11;
    }

    public String getValue() {
        return value;
    }
}