package org.felipe_jaber.a1testedesoftware.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Sell {
    private UUID id;
    private Book book;
    private Customer customer;
    private Employee employee;
    private Integer quantity;
    private BigDecimal price;
    private LocalDateTime sellDate;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public LocalDateTime getSellDate() { return sellDate; }
    public void setSellDate(LocalDateTime sellDate) { this.sellDate = sellDate; }
}
