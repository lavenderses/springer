package com.nakanoi.springer.advance.commons;

import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/** Simple common result data method arg resolver. */
public class CommonRequestDataMethodArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return CommonRequestData.class.isAssignableFrom(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(
      MethodParameter parameter,
      ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory)
      throws Exception {
    HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
    CommonRequestData commonRequestData = new CommonRequestData();

    if (request == null) {
      commonRequestData.setUserAgent("");
      commonRequestData.setSessionId("");
    } else {
      HttpSession session = Objects.requireNonNull(request).getSession(false);
      String userAgent = webRequest.getHeader(HttpHeaders.USER_AGENT);
      String sessionId = Optional.ofNullable(session).map(HttpSession::getId).orElse(null);
      commonRequestData.setUserAgent(userAgent);
      commonRequestData.setSessionId(sessionId);
    }

    return commonRequestData;
  }
}
