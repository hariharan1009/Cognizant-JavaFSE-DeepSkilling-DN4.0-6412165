package com.library.serices;

import com.library.repository.BookRepository;

public class BookService {
    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public String addBook(){
        return bookRepository.insertBook();
    }
}
