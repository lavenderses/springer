package com.nakanoi.springer.rest.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Book not found exception. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
  public BookNotFoundException(String bookId) {
    super("Book is not found (book ID = " + bookId + ").");
  }
}
