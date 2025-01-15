package com.example.bookstore.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cart")
public class CartE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserE user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookE book;

    @Column(name = "quantity")
    private Double quantity;

    public CartE() {
    }

    public CartE(Long id, UserE user, BookE book, Double quantity) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserE getUser() {
        return user;
    }

    public void setUser(UserE user) {
        this.user = user;
    }

    public BookE getBook() {
        return book;
    }

    public void setBook(BookE book) {
        this.book = book;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
