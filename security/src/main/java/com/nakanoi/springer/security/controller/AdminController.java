package com.nakanoi.springer.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple controller for user auth. */
@Controller
@RequestMapping("/admin")
public class AdminController {
  @GetMapping
  public String getAdmin() {
    return "admin";
  }
}
