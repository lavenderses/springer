package com.nakanoi.springer.rest.book;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

/** Book resource for rest. */
public class BookResource implements Serializable {
  private static final long serialVersionUID = 1L;
  private String bookId;
  private String name;

  @JsonFormat(pattern = "yyyy-MM-dd")
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
    return LocalDate.of(publishedDate.getYear(), publishedDate.getMonth(), publishedDate.getDayOfMonth());
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = LocalDate.of(publishedDate.getYear(), publishedDate.getMonth(), publishedDate.getDayOfMonth());
  }
}
