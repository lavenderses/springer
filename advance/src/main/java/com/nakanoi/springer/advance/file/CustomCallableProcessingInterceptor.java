package com.nakanoi.springer.advance.file;

import java.util.concurrent.Callable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CustomCallableProcessingInterceptor implements CallableProcessingInterceptor {
  @Override
  public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
    return "error/timeoutError";
  }
}
