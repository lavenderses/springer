package com.nakanoi.springer.advance.commons;

/** Simple common result data class. */
public class CommonRequestData {
  private String userAgent;
  private String sessionId;

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }
}
