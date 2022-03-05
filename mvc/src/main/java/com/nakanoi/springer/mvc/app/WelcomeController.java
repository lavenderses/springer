package com.nakanoi.springer.mvc.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple controller. */
@Controller
@RequestMapping("/")
public class WelcomeController {

  @GetMapping
  public String home() {
    return "index";
  }
}
