package org.felipe_jaber.a1testedesoftware.domain.entity;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String isbn;
    private Author author;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}
