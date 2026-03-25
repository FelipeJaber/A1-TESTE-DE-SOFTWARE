package org.felipe_jaber.a1testedesoftware.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "stock")
@Getter
@Setter
public class StockEntity {
    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false, unique = true)
    private BookEntity book;

    @Column(nullable = false)
    private Integer quantity;
}
