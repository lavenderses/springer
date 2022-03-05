package com.nakanoi.springer.mvc.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** Only rendering sign up controller. */
@Controller
@RequestMapping("/signup")
public class SignUpController {

  @GetMapping(params = "form")
  @ResponseBody
  public String form(@RequestParam("form") String form) {
    return "Form: " + form;
  }

  @PostMapping(params = "confirm")
  @ResponseBody
  public String confirm(@RequestParam("confirm") String confirm) {
    return "Confirm: " + confirm;
  }

  @PostMapping(params = "redo")
  @ResponseBody
  public String redo(@RequestParam("redo") String redo) {
    return "Redo: " + redo;
  }

  @PostMapping(params = "create")
  @ResponseBody
  public String create(@RequestParam("create") String create) {
    return "Create: " + create;
  }

  @GetMapping(params = "complete")
  @ResponseBody
  public String complete(@RequestParam("complete") String complete) {
    return "Complete: " + complete;
  }
}
