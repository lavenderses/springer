package com.nakanoi.springer.rest.book;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Simple book exception handler. */
@RestControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {
  private final Map<Class<? extends Exception>, String> messageMappings =
      Collections.unmodifiableMap(
          new LinkedHashMap<>() {
            {
              put(HttpMessageNotReadableException.class, "Request body is invalid");
            }
          });

  private String resolveMessage(Exception e, String defaultMessage) {
    return messageMappings.entrySet().stream()
        .filter(entry -> entry.getKey().isAssignableFrom(e.getClass()))
        .findFirst()
        .map(Map.Entry::getValue)
        .orElse(defaultMessage);
  }

  private BookError createBookError(Exception e) {
    BookError bookError = new BookError();
    bookError.setMessage(resolveMessage(e, e.getMessage()));
    bookError.setDocumentationUrl("http://localhost:8080/rest/doc/errors");
    return bookError;
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception e, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    BookError bookError = createBookError(e);
    return super.handleExceptionInternal(e, bookError, headers, status, request);
  }
}
