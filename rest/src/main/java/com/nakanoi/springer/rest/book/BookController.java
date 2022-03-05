package com.nakanoi.springer.rest.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Simple book rest controller. */
@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired BookService bookService;

  @GetMapping("/{bookId}")
  public BookResource getBook(@PathVariable String bookId) {
    bookService.loadDummyData();

    Book book = bookService.find(bookId);
    BookResource resource = new BookResource();
    resource.setBookId(book.getBookId());
    resource.setName(book.getName());
    resource.setPublishedDate(book.getPublishedDate());

    return resource;
  }
}
