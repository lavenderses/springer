package com.nakanoi.springer.rest.book;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Simple book service logic. */
@Service
public class BookService {
  private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

  public void loadDummyData() {
    Book book = new Book();
    book.setBookId("0000-0000-0000-0000");
    book.setName("Title");
    book.setPublishedDate(LocalDate.now());
    bookRepository.put(book.getBookId(), book);
  }

  /**
   * Find book from book repo.
   *
   * @param bookId Book ID string.
   * @return Book object or null if not exist.
   */
  public Book find(String bookId) {
    return bookRepository.get(bookId);
  }
}
