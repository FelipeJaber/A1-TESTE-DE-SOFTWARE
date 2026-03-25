package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class AuthorEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String nationality;
}
