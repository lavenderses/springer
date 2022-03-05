package com.nakanoi.springer.rest.book;

import java.time.LocalDate;

/** Simple book class. */
public class Book {
  private String bookId;
  private String name;
  private LocalDate publishedDate;

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
}
