package com.nakanoi.springer.security.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/** Simple event listener for auth. */
@Component
public class AuthenticationEventListener {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationEventListener.class);

  @EventListener
  public void handleBandCredentials(AuthenticationFailureBadCredentialsEvent event) {
    logger.info("BAD credentials detected. username: {}", event.getAuthentication().getName());
  }
}
