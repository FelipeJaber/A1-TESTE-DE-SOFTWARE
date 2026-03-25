package org.felipe_jaber.a1testedesoftware.domain.entity;

import org.felipe_jaber.a1testedesoftware.domain.valueobject.CPF;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.Email;
import org.felipe_jaber.a1testedesoftware.domain.valueobject.PhoneNumber;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private CPF cpf;
    private PhoneNumber number;
    private Email email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    public void setNumber(PhoneNumber number) {
        this.number = number;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
