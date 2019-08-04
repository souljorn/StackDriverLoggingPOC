package com.stackdriverpoc.Model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    public Book() {}

    public Book(String title , String author) {
        this.title = title;
        this.author = author;
    }
}