package com.example.bookstore.Entity.Repository;

import com.example.bookstore.Entity.BookE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookE, Long> {
}