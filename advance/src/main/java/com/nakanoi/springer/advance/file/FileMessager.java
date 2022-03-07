package com.nakanoi.springer.advance.file;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/** Simple message pusher for file. */
@Component
public class FileMessager {
  @Async
  public void send(SseEmitter emitter) throws IOException, InterruptedException {
    emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("Send file."));
    TimeUnit.SECONDS.sleep(1);

    emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("For us."));
    TimeUnit.SECONDS.sleep(1);

    emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("DO EARLY."));
    TimeUnit.SECONDS.sleep(1);

    emitter.complete();
  }
}
