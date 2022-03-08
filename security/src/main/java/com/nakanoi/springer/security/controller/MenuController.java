package com.nakanoi.springer.security.controller;

import com.nakanoi.springer.security.user.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple menu controller. */
@Controller
@RequestMapping("/menu")
public class MenuController {
  @GetMapping
  public String getMenu(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
    model.addAttribute("user", userDetails.getUser());
    return "menu";
  }
}
