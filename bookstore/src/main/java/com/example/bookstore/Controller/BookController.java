package com.example.bookstore.Controller;


import com.example.bookstore.Business.Service.BookService;
import com.example.bookstore.DTO.Book_Dto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService; // BookService enjekte ediyoruz.

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/list")
    public List<Book_Dto> getBooks(
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String titleFilter) {

        return bookService.getAll(sortBy, order, titleFilter);
    }
}