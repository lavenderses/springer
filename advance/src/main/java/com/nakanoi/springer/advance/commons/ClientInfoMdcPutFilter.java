package com.nakanoi.springer.advance.commons;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

/** Simple mdc filter. */
public class ClientInfoMdcPutFilter extends OncePerRequestFilter {
  private static final String FORWARDED_FOR_HEADER_NAME = "X-Forwarded-For";
  private String mdcKey = FORWARDED_FOR_HEADER_NAME;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String remoteIp =
        Optional.ofNullable(request.getHeader(FORWARDED_FOR_HEADER_NAME))
            .orElse(request.getRemoteAddr());
    MDC.put(mdcKey, remoteIp);
    try {
      filterChain.doFilter(request, response);
    } finally {
      MDC.remove(mdcKey);
    }
  }

  public String getMdcKey() {
    return mdcKey;
  }

  public void setMdcKey(String mdcKey) {
    this.mdcKey = mdcKey;
  }
}
