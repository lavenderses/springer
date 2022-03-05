package com.nakanoi.springer.rest.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

/** Book resource for rest. */
public class BookResource implements Serializable {
  private static final long serialVersionUID = 1L;
  private String bookId;
  @NotNull private String name;
  @NotNull private List<String> authors;

  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishedDate;

  @NotNull private PublisherResource publisher;

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

  public PublisherResource getPublisher() {
    return publisher.clone();
  }

  public void setPublisher(PublisherResource publisher) {
    this.publisher = publisher.clone();
  }
}
