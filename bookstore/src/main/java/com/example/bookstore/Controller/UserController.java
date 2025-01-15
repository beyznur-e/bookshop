package com.example.bookstore.Controller;

import com.example.bookstore.Business.UserI;
import com.example.bookstore.DTO.User_Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class UserController {
    private final UserI userI;

    @Autowired
    public UserController(UserI userI) {
        this.userI = userI;
    }

    @PostMapping("/add")
    public void add(@RequestBody User_Dto user_dto){
        userI.add(user_dto);
    }

    @PostMapping("/update")
    public void update(@RequestBody User_Dto user_dto){
        userI.update(user_dto);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        userI.delete(id);
    }

}
