package com.nakanoi.springer.mvc.app;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Simple echo controller. */
@Controller
@RequestMapping("/echo")
public class EchoController {

  @GetMapping
  public String viewInput(Model model) {
    EchoForm echoForm = new EchoForm();
    model.addAttribute(echoForm);
    return "echo/input";
  }

  @PostMapping
  public String echo(@Valid EchoForm echoForm, BindingResult result) {
    return result.hasErrors() ? "echo/input" : "echo/output";
  }
}
