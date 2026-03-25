package org.felipe_jaber.a1testedesoftware.domain.entity;

import java.util.UUID;

public class Stock {
    private UUID id;
    private Book book;
    private Integer quantity;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
