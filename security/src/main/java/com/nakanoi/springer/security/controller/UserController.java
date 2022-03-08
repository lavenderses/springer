package com.nakanoi.springer.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Simple controller for user auth. */
@Controller
public class UserController {
  @GetMapping("/login")
  public String loginForm() {
    return "loginForm";
  }
}
