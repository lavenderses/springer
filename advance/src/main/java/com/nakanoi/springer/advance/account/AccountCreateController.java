package com.nakanoi.springer.advance.account;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/** Simple controller for account creation. */
@Controller
@RequestMapping("/accounts")
@SessionAttributes(types = AccountCreateForm.class)
public class AccountCreateController {
  @GetMapping
  public String getForm() {
    return "accounts/form";
  }

  @GetMapping("/succeeded")
  public String succeeded(SessionStatus sessionStatus) {
    sessionStatus.setComplete();
    return "accounts/succeeded";
  }

  @PostMapping
  public String postForm(@Validated AccountCreateForm form, BindingResult result) {
    return result.hasErrors() ? "accounts/form" : "redirect:/accounts/succeeded";
  }

  @ModelAttribute
  public AccountCreateForm accountCreateForm() {
    return new AccountCreateForm();
  }
}
