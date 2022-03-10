package com.nakanoi.boot.controller;

import com.nakanoi.boot.domain.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Simple message controller. */
@RestController
@RequestMapping("/message")
public class MessagesController {
  final List<Message> messages = new CopyOnWriteArrayList<>();

  @GetMapping
  public List<Message> getMessages() {
    return messages;
  }

  @PostMapping
  public Message postMessage(@RequestBody Message message) {
    messages.add(message);
    return message;
  }
}
