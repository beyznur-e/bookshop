package com.example.bookstore.Entity.Repository;

import com.example.bookstore.Entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserE, Long> {
    Optional<UserE> findByEmail(String email);
}
