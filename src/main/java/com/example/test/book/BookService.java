package com.example.test.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;


    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Iterable<Book> searchBooks(){
        return bookRepository.findAll();
    }

    public Object searchOneBook(int id){
        return bookRepository.findById(id);
    }

    public void deleteOneBook(int id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void changeBook(Book book){
        bookRepository.save(book);
    }

    

}
