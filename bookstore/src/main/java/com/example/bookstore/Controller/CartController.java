package com.example.bookstore.Controller;


import com.example.bookstore.Business.Service.CartService;
import com.example.bookstore.DTO.Cart_Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart_Dto cart_dto) {
        cartService.addToCart(cart_dto);
        return ResponseEntity.ok("Product added to cart successfully!");
    }
}
