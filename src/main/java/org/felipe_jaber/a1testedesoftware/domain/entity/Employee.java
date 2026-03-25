package org.felipe_jaber.a1testedesoftware.domain.entity;

import java.util.UUID;

public class Employee {
    private UUID id;
    private String name;
    private String registration;
    private String position;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
