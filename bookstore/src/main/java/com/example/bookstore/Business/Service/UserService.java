package com.example.bookstore.Business.Service;

import com.example.bookstore.Business.UserI;
import com.example.bookstore.DTO.User_Dto;
import com.example.bookstore.Entity.Repository.UserRepository;
import com.example.bookstore.Entity.UserE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserI {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User_Dto user_dto) {
        UserE user = new UserE();
        user.setName(user_dto.getName());
        user.setEmail(user_dto.getEmail());
        user.setPassword(user_dto.getPassword());
        user.setRole(user_dto.getRole());
        userRepository.save(user);
    }

    @Override
    public void update(User_Dto user_dto) {
        UserE user = new UserE();
        user.setName(user_dto.getName());
        user.setEmail(user_dto.getEmail());
        user.setPassword(user_dto.getPassword());
        user.setRole(user_dto.getRole());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        // Önce belirtilen ID'ye sahip bir kullanıcı var mı?
        if (userRepository.existsById(id)) {
            // Kullanıcı varsa sil
            userRepository.deleteById(id);
        } else {
            // Kullanıcı yoksa hata fırlat
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
    }
}
