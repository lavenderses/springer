package com.nakanoi.springer.rest.book;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Simple book exception handler. */
@RestControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {
  @Autowired MessageSource messageSource;

  private final Map<Class<? extends Exception>, String> messageMappings =
      Collections.unmodifiableMap(
          new LinkedHashMap<>() {
            {
              put(HttpMessageNotReadableException.class, "Request body is invalid.");
              put(MethodArgumentNotValidException.class, "Request format is invalid.");
            }
          });

  private String resolveMessage(Exception e, String defaultMessage) {
    return messageMappings.entrySet().stream()
        .filter(entry -> entry.getKey().isAssignableFrom(e.getClass()))
        .findFirst()
        .map(Map.Entry::getValue)
        .orElse(defaultMessage);
  }

  private BookError createBookError(Exception e, String defaultMessage) {
    BookError bookError = new BookError();
    bookError.setMessage(resolveMessage(e, defaultMessage));
    bookError.setDocumentationUrl("http://localhost:8080/rest/doc/errors");
    return bookError;
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception e, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
    BookError bookError = createBookError(e, e.getMessage());
    return super.handleExceptionInternal(e, bookError, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    BookError error = new BookError();
    ex.getBindingResult()
        .getGlobalErrors()
        .forEach(e -> error.addDetails(e.getObjectName(), getMessage(e, request)));
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(e -> error.addDetails(e.getField(), getMessage(e, request)));
    return super.handleExceptionInternal(ex, error, headers, status, request);
  }

  @ExceptionHandler
  public ResponseEntity<Object> handleBookNotFoundException(
      BookNotFoundException e, WebRequest request) {
    return handleExceptionInternal(e, null, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler
  public ResponseEntity<Object> handleSystemException(Exception e, WebRequest request) {
    BookError error = new BookError();
    error.setMessage(resolveMessage(e, "Something wrong happened."));
    error.setDocumentationUrl("http://localhost:8080/rest/doc");
    return handleExceptionInternal(
        e, error, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  private String getMessage(MessageSourceResolvable resolvable, WebRequest request) {
    return messageSource.getMessage(resolvable, request.getLocale());
  }
}
