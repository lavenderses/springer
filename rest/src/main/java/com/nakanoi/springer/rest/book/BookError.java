package com.nakanoi.springer.rest.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Simple book error class. */
public class BookError implements Serializable {
  public static class Details implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String target;
    private final String message;

    private Details(String target, String message) {
      this.target = target;
      this.message = message;
    }

    public String getTarget() {
      return target;
    }

    public String getMessage() {
      return message;
    }
  }

  private static final long serialVersionUID = 1L;

  private String message;

  @JsonProperty("documentation_url")
  private String documentationUrl;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private final List<Details> details = new ArrayList<>();

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

  public void addDetails(String target, String message) {
    details.add(new Details(target, message));
  }

  public List<Details> getDetails() {
    return new ArrayList<>(details);
  }
}
