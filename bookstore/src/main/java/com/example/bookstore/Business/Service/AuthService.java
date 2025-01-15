package com.example.bookstore.Business.Service;

import com.example.bookstore.DTO.Login_Dto;
import com.example.bookstore.Entity.Repository.UserRepository;
import com.example.bookstore.Entity.UserE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean login(Login_Dto login_dto){

        //Email ile kullanıcı bulma
        UserE user = userRepository.findByEmail(login_dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz email veya parola"));

        //Şifre kontrolü
        if(user.getPassword().equals(login_dto.getPassword())){
            return true;
        }
        else{
            throw new IllegalArgumentException("Geçersiz email veya parola");
        }
    }
}
