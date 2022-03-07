package com.nakanoi.springer.test.domain;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/** Simple message service. */
@Service
public class MessageService {
  @Autowired MessageSource messageSource;

  @Value("${auth.failureCountToLock:5}")
  private int failureCountLock;

  public String getMessage() {
    return "Hello world.";
  }

  public String getMessageByCode(String code) {
    return messageSource.getMessage(code, null, Locale.getDefault());
  }

  public int getFailureCountLock() {
    return failureCountLock;
  }
}
