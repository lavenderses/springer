package com.nakanoi.springer.rest.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Simple book class. */
public class Book {
  private String bookId;
  private String name;
  private List<String> authors;
  private LocalDate publishedDate;
  private Publisher publisher;

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getAuthors() {
    return new ArrayList<>(authors);
  }

  public void setAuthors(List<String> authors) {
    this.authors = new ArrayList<>(authors);
  }

  public LocalDate getPublishedDate() {
    if (publishedDate == null) {
      return null;
    }
    return LocalDate.of(
        publishedDate.getYear(), publishedDate.getMonth(), publishedDate.getDayOfMonth());
  }

  public void setPublishedDate(LocalDate publishedDate) {
    if (publishedDate == null) {
      return;
    }
    this.publishedDate =
        LocalDate.of(
            publishedDate.getYear(), publishedDate.getMonth(), publishedDate.getDayOfMonth());
  }

  public Publisher getPublisher() {
    return publisher.clone();
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher.clone();
  }
}
