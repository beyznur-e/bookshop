package com.example.bookstore.Business.Service;

import com.example.bookstore.Business.CartI;
import com.example.bookstore.DTO.Cart_Dto;
import com.example.bookstore.Entity.BookE;
import com.example.bookstore.Entity.CartE;
import com.example.bookstore.Entity.Repository.BookRepository;
import com.example.bookstore.Entity.Repository.CartRepository;
import com.example.bookstore.Entity.Repository.UserRepository;
import com.example.bookstore.Entity.UserE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartI {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    //Sepete ürün ekleme
    @Override
    public void addToCart(Cart_Dto cart_dto) {
        // Veritabanında mevcut kayıt var mı?
        CartE existingCartItem = cartRepository.findByUser_IdAndBook_Id(
                cart_dto.getUser_id(), cart_dto.getBook_id()
        ).orElse(null);

        if (existingCartItem != null) {
            // Mevcutsa miktarı artır
            double newQuantity = existingCartItem.getQuantity() + cart_dto.getQuantity();
            existingCartItem.setQuantity(newQuantity);
            cartRepository.save(existingCartItem);
        } else {
            // Yeni kayıt oluştur
            CartE newCartItem = new CartE();

            // UserE ve BookE nesnelerini buluyoruz
            UserE user = userRepository.findById(cart_dto.getUser_id())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            BookE book = bookRepository.findById(cart_dto.getBook_id())
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            newCartItem.setUser(user);   // UserE nesnesini set et
            newCartItem.setBook(book);   // BookE nesnesini set et
            newCartItem.setQuantity(cart_dto.getQuantity());  // Quantity'yi set et

            cartRepository.save(newCartItem);
        }
    }


}