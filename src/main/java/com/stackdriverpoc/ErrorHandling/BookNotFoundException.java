package com.stackdriverpoc.ErrorHandling;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not find Book " + id);
    }
}
