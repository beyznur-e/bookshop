package com.example.bookstore.Business;

import com.example.bookstore.DTO.User_Dto;

public interface UserI {
    void add(User_Dto user_dto);
    void update(User_Dto user_dto);
    void delete(Long id);

}
