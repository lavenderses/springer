package com.nakanoi.springer.rest.book;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

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
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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
              resource.setAuthors(book.getAuthors());
              resource.setPublishedDate(book.getPublishedDate());
              resource.setPublisher(
                  new PublisherResource(
                      book.getPublisher().getName(), book.getPublisher().getTel()));
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
    resource.setAuthors(book.getAuthors());
    resource.setPublishedDate(book.getPublishedDate());
    resource.setPublisher(
        new PublisherResource(book.getPublisher().getName(), book.getPublisher().getTel()));

    return resource;
  }

  @PostMapping
  public ResponseEntity<Void> createBook(
      @Validated @RequestBody BookResource bookResource, UriComponentsBuilder uriBuilder) {
    Book newBook = new Book();
    newBook.setName(bookResource.getName());
    newBook.setAuthors(bookResource.getAuthors());
    newBook.setPublishedDate(bookResource.getPublishedDate());
    newBook.setPublisher(
        new Publisher(bookResource.getPublisher().getName(), bookResource.getPublisher().getTel()));

    Book createBook = bookService.create(newBook);
    // URI resourceUri =
    //
    // uriBuilder.path("/books/{bookId}").buildAndExpand(createBook.getBookId()).encode().toUri();
    URI resourceUri =
        MvcUriComponentsBuilder.relativeTo(uriBuilder)
            .withMethodCall(on(BookController.class).getBook(createBook.getBookId()))
            .build()
            .encode()
            .toUri();
    return ResponseEntity.created(resourceUri).build();
  }

  @PutMapping("/{bookId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateBook(
      @PathVariable String bookId, @Validated @RequestBody BookResource bookResource) {
    Book book = new Book();
    book.setBookId(bookId);
    book.setName(bookResource.getName());
    book.setAuthors(bookResource.getAuthors());
    book.setPublishedDate(bookResource.getPublishedDate());
    book.setPublisher(
        new Publisher(bookResource.getPublisher().getName(), bookResource.getPublisher().getTel()));

    bookService.update(book);
  }

  @DeleteMapping("/{bookId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBook(@PathVariable String bookId) {
    bookService.delete(bookId);
  }
}
