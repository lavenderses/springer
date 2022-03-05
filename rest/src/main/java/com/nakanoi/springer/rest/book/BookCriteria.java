package com.nakanoi.springer.rest.book;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/** Simple book criteria. */
public class BookCriteria implements Serializable {
  private static final long serialVersionUID = 1L;
  private String bookId;
  private String name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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
