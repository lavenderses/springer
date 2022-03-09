package com.nakanoi.springer.jpa.room;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

/** Simple auditor for room entity. */
public class RoomAuditorAware implements AuditorAware<String> {
  @Value("#{systemProperties['user.name']}")
  private String username;

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.ofNullable(username);
  }
}
