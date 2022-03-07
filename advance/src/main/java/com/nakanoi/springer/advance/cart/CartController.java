package com.nakanoi.springer.advance.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple cart controller. */
@Controller
@RequestMapping("/carts")
public class CartController {
  @Autowired Cart cart;

  @GetMapping
  public String getCart() {
    return "carts/index";
  }
}
