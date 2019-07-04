package com.stackdriverpoc;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find Book " + id);
    }
}
