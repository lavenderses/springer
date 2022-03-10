package com.nakanoi.boot.controller;

import com.nakanoi.boot.domain.Message;
import com.nakanoi.boot.domain.MessageEntity;
import com.nakanoi.boot.mapper.MessageMapper;
import com.nakanoi.boot.repository.MessageRepository;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Simple message controller. */
@RestController
@RequestMapping("/message")
public class MessagesController {
  private final List<Message> messages = new CopyOnWriteArrayList<>();
  private final JdbcTemplate jdbcTemplate;
  private final MessageRepository messageRepository;
  private final MessageMapper messageMapper;

  public MessagesController(
      JdbcTemplate jdbcTemplate, MessageRepository messageRepository, MessageMapper messageMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.messageRepository = messageRepository;
    this.messageMapper = messageMapper;
  }

  @GetMapping
  public List<Message> getMessages() {
    return messages;
  }

  @GetMapping("/jdbc")
  public List<Message> getMessagesWithJdbc() {
    return jdbcTemplate.query(
        "SELECT text FROM messages ORDER BY id",
        (rs, i) -> {
          Message m = new Message();
          m.setText(rs.getString("text"));
          return m;
        });
  }

  @GetMapping("/jpa")
  public List<MessageEntity> getMessageWithJpa() {
    return messageRepository.findAll();
  }

  @GetMapping("/mybatis")
  public List<Message> getMessageWithMyBatis() {
    return messageMapper.findAll();
  }

  @PostMapping
  public Message postMessage(@RequestBody Message message) {
    messages.add(message);
    return message;
  }

  @PostMapping("/jpa")
  public MessageEntity postMessageWithJpa(@RequestBody MessageEntity message) {
    return messageRepository.save(message);
  }

  @PostMapping("/mybatis")
  public Message postMessageWithMyBatis(@RequestBody Message message) {
    messageMapper.create(message);
    return message;
  }
}
