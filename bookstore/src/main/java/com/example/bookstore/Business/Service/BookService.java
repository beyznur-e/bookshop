package com.example.bookstore.Business.Service;


import com.example.bookstore.Business.BookI;
import com.example.bookstore.DTO.Book_Dto;
import com.example.bookstore.Entity.BookE;
import com.example.bookstore.Entity.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements BookI {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book_Dto> getAll(String sortBy, String order, String titleFilter) {
        // Kitapları repository'den çekiyoruz
        List<BookE> books = bookRepository.findAll();

        // Stream kullanarak filtreleme ve sıralama işlemlerini gerçekleştiriyoruz
        return books.stream()
                .filter(book -> titleFilter == null || //Eğer titleFilter null değilse (yani kullanıcı bir başlık girmişse), sadece başlığında bu kelimeyi içeren kitaplar geçerli olacak.
                        book.getTitle().toLowerCase().contains(titleFilter.toLowerCase())) // Burada büyük-küçük harf farkı gözetmeden başlıkların içerisinde titleFilter kelimesi olup olmadığına bakıyoruz.
                .sorted((b1, b2) -> { // Sıralama
                    int comparison;
                    if ("price".equalsIgnoreCase(sortBy)) { //Eğer sortBy "price" ise, kitapları fiyatlarına göre sıralıyoruz.
                        comparison = Double.compare(b1.getPrice(), b2.getPrice());
                    } else {
                        comparison = b1.getTitle().compareToIgnoreCase(b2.getTitle()); //Eğer "price" değilse, başlıklarına göre sıralama yapıyoruz.
                    }
                    return "desc".equalsIgnoreCase(order) ? -comparison : comparison; //Sıralama artan mı yoksa azalan mı ?
                })
                .map(book -> new Book_Dto( //BookE nesnesini bir Book_Dto nesnesine dönüştürüyoruz.
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getCategory(),
                        book.getStock())) // Book -> Book_Dto dönüşümü
                .collect(Collectors.toList()); }
}
