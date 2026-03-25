package org.felipe_jaber.a1testedesoftware.domain.entity;

import java.util.UUID;

public class Author {
    private UUID id;
    private String name;
    private String nationality;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
}
