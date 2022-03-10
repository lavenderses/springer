package com.nakanoi.boot.controller;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple controller for thymeleaf. */
@Controller
@RequestMapping("/hello")
public class HelloController {
  private final MessageSource messageSource;

  public HelloController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping
  public String getHello(Model model) {
    model.addAttribute("hello", "Hello world.");
    model.addAttribute("title", messageSource.getMessage("app.title", null, Locale.getDefault()));
    return "hello";
  }
}
