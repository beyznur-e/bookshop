package com.example.bookstore.Entity.Repository;

import com.example.bookstore.Entity.OrderE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderE, Long> {
}
