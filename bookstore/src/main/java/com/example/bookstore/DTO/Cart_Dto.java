package com.example.bookstore.DTO;

import com.example.bookstore.Entity.CartE;

public class Cart_Dto {
    private Long id;
    private Long user_id;
    private Long book_id;
    private Double quantity;

    public Cart_Dto(Long id, Long user_id, Long book_id, Double quantity) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public static Cart_Dto fromEntity(CartE cartE) {
        return new Cart_Dto(
                cartE.getId(),
                cartE.getUser().getId(), // UserE içindeki id alınır
                cartE.getBook().getId(), // BookE içindeki id alınır
                cartE.getQuantity()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}