package com.example.bookstore.Business;

import com.example.bookstore.DTO.Book_Dto;

import java.util.List;

public interface BookI {
    List<Book_Dto> getAll(String sortBy, String order, String titleFilter);
    //sortBy: Kitapları hangi özelliğe göre sıralayacağımızı belirtir (örneğin, başlık, yazar, fiyat vb.).
    //order: Sıralama düzenini belirtir. Bu asc (artan) veya desc (azalan) olabilir.
    //titleFilter: Eğer kullanıcı kitapları başlıklarına göre filtrelemek isterse, bu filtre burada devreye girer. Örneğin, "Java" kelimesini içeren kitaplar listelenecektir.
}
