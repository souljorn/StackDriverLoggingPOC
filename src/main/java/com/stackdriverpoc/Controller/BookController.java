package com.stackdriverpoc.Controller;

import com.stackdriverpoc.Book;
import com.stackdriverpoc.BookNotFoundException;
import com.stackdriverpoc.BookRepo;
import com.stackdriverpoc.Controller.Aspect.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class BookController {
    private String name;
    private String url;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    private final BookRepo repository;

    BookController(BookRepo repository) {
        this.repository = repository;
    }


    @LogExecutionTime
    @GetMapping("/books")
    List<Book> all() {
        List<Book> temp = repository.findAll();
        List<String> collect = temp.stream().map(x -> x.getAuthor()).collect(Collectors.toList());
        String str = collect.stream().map(x -> String.valueOf(x)).collect(Collectors.joining("---", "|", "|"));
        LOGGER.info("Getting all books " + str);
        return temp;
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // Single item

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}