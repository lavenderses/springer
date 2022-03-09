package com.nakanoi.springer.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller for room. */
@Controller
@RequestMapping("/")
public class RoomController {
  @GetMapping
  @ResponseBody
  public String getRooms() {
    return "Succeeded.";
  }
}
