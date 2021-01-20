package com.example.test.book;

import com.example.test.exceptions.RequestErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("${spring.base-path}/book")
public class BookController {
    

    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> add (@RequestBody Book book){
        try {
            bookService.addBook(book);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RequestErrorResponse("Unable to save"));

        }
    }

    @GetMapping
    public Iterable search(){
        Iterable bookList = bookService.searchBooks();
        
        for(Object object : bookList){
            System.out.println(object.toString());
        }
        return bookList;
    }

    @GetMapping("/{id}")
    public Object searchOne(@PathVariable int id){
        return bookService.searchOneBook(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable int id){
        bookService.deleteOneBook(id);
        return ResponseEntity.ok("Successfully Deleted.....!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Book book){
        bookService.updateBook(book);
        return ResponseEntity.ok("Successfully Updated.....!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> change(@PathVariable int id, @RequestBody Book book){
        bookService.changeBook(book);
        return ResponseEntity.ok("Successfully Changed.....!");
    }

}
