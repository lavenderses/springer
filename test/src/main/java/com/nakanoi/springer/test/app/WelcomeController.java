package com.nakanoi.springer.test.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple welcome controller. */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
  @GetMapping
  public String getWelcome() {
    return "index";
  }
}
