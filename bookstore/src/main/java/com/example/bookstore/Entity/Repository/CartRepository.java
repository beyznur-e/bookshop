package com.example.bookstore.Entity.Repository;

import com.example.bookstore.Entity.CartE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartE, Long> {
    Optional<CartE> findByUser_IdAndBook_Id(Long userId, Long bookId);
}