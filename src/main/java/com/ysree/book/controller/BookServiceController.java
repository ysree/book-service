package com.ysree.book.controller;

import com.ysree.book.dao.BookRepository;
import com.ysree.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BookServiceController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "/books/{id}", produces = "application/json")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping(path = "/books", produces = "application/json")
    public @ResponseBody Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(path="/add-book", produces = "application/json")
    public @ResponseBody Book addNewUser(@RequestParam(value = "book_name") String bookName,
                     @RequestParam(value="author") String author,
                     @RequestParam(value="price") Double price) {
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setPrice(price);
        return bookRepository.save(book);
    }
}
