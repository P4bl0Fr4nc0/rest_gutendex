package com.example.restgutendex.controller;


import com.example.restgutendex.entity.Book;
import com.example.restgutendex.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;

    }


    @PostMapping("/fetch")

    public List<Book>  fetchAndSaveBooks(){
        return bookService.fetchAndSaveBooks();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/fetch/by-title")
    public Book fetchAndSaveBookByTitle(@RequestParam String title) {
        return bookService.fetchAndSaveBookByTitle(title);
    }


}
