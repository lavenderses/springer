package com.nakanoi.springer.rest.book;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** Simple book rest controller. */
@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired BookService bookService;

  @GetMapping
  public List<BookResource> books(@Validated BookResourceQuery query) {
    bookService.loadDummyData();

    BookCriteria criteria = new BookCriteria();
    criteria.setName(query.getName());
    criteria.setPublishedDate(query.getPublishedDate());

    List<Book> books = bookService.findAllByCriteria(criteria);
    return books.stream()
        .map(
            book -> {
              BookResource resource = new BookResource();
              resource.setBookId(book.getBookId());
              resource.setName(book.getName());
              resource.setPublishedDate(book.getPublishedDate());
              return resource;
            })
        .collect(Collectors.toList());
  }

  @GetMapping("/{bookId}")
  public BookResource getBook(@PathVariable String bookId) {
    bookService.loadDummyData();

    Book book = bookService.find(bookId);
    if (book == null) {
      throw new BookNotFoundException(bookId);
    }
    BookResource resource = new BookResource();
    resource.setBookId(book.getBookId());
    resource.setName(book.getName());
    resource.setPublishedDate(book.getPublishedDate());

    return resource;
  }

  @PostMapping
  public ResponseEntity<Void> createBook(@Validated @RequestBody BookResource bookResource) {
    Book newBook = new Book();
    newBook.setName(bookResource.getName());
    newBook.setPublishedDate(bookResource.getPublishedDate());

    Book createBook = bookService.create(newBook);
    String resourceUri = "http://localhost:8080/rest/books/" + createBook.getBookId();
    return ResponseEntity.created(URI.create(resourceUri)).build();
  }

  @PutMapping("/{bookId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBook(
      @PathVariable String bookId, @Validated @RequestBody BookResource bookResource) {
    Book book = new Book();
    book.setBookId(bookId);
    book.setName(bookResource.getName());
    book.setPublishedDate(bookResource.getPublishedDate());

    bookService.update(book);
  }

  @DeleteMapping("/{bookId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBook(@PathVariable String bookId) {
    bookService.delete(bookId);
  }
}
