package com.nakanoi.springer.advance.cart;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple cart access controller. */
@Controller
@RequestMapping("/carts-access")
public class CartAccessController {
  @Autowired Cart cart;

  @GetMapping
  public String getCartWithNewAccess() {
    cart.setLastAccess(new Date());
    return "carts/access";
  }
}
