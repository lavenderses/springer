package com.nakanoi.springer.mvc.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple account controller. */
@Controller
@RequestMapping("/account")
public class AccountController {

  @GetMapping
  public String accountSignUp(Model model) {
    model.addAttribute(new AccountCreateForm());
    return "account/create";
  }

  @PostMapping(params = "card.type=1")
  public String accountSignedUpForFree(
      @Validated(AccountCard.FreeAccount.class) AccountCreateForm form,
      BindingResult result,
      Model model) {
    return result.hasErrors() ? "account/create" : "account/succeeded";
  }

  @PostMapping(params = "card.type=2")
  public String accountSignedUpForPay(
      @Validated(AccountCard.PaymentAccount.class) AccountCreateForm form,
      BindingResult result,
      Model model) {
    return result.hasErrors() ? "account/create" : "account/succeeded";
  }
}
