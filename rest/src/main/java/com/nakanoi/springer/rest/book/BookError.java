package com.nakanoi.springer.rest.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/** Simple book error class. */
public class BookError implements Serializable {
  private static final long serialVersionUID = 1L;

  private String message;

  @JsonProperty("documentation_url")
  private String documentationUrl;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDocumentationUrl() {
    return documentationUrl;
  }

  public void setDocumentationUrl(String documentationUrl) {
    this.documentationUrl = documentationUrl;
  }
}
