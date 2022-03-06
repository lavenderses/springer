package com.nakanoi.springer.rest.book;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/** Simple book service logic. */
@Service
public class BookService {
  private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

  public void loadDummyData() {
    Book book = new Book();
    book.setBookId("0000-0000-0000-0000");
    book.setName("Title");
    book.setAuthors(List.of("Alice", "Bob"));
    book.setPublishedDate(LocalDate.now());
    book.setPublisher(new Publisher("Pub corp", "012-3456-7890"));
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

  /**
   * Find all book from criteria.
   *
   * @param criteria Criteria for finding books.
   * @return Books found.
   */
  public List<Book> findAllByCriteria(BookCriteria criteria) {
    return bookRepository.values().stream()
        .filter(
            book ->
                (criteria.getName() == null || book.getName().contains(criteria.getName()))
                    && (criteria.getPublishedDate() == null
                        || book.getPublishedDate().equals(criteria.getPublishedDate())))
        .sorted(Comparator.comparing(Book::getPublishedDate))
        .collect(Collectors.toList());
  }

  /**
   * Create new book object.
   *
   * @param newBook New book object.
   * @return New book which created.
   */
  public Book create(Book newBook) {
    String bookId = UUID.randomUUID().toString();
    newBook.setBookId(bookId);
    bookRepository.put(bookId, newBook);

    return newBook;
  }

  /**
   * Update existing book or create it if it doesn't exist.
   *
   * @param book Book to be updated.
   */
  public void update(Book book) {
    bookRepository.put(book.getBookId(), book);
  }

  /**
   * Delete book.
   *
   * @param bookId Book ID string to be removed.
   */
  public void delete(String bookId) {
    bookRepository.remove(bookId);
  }
}
