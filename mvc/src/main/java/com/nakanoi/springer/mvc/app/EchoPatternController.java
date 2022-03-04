package com.nakanoi.springer.mvc.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller to echo request pattern. */
@Controller
@RequestMapping("/pattern")
public class EchoPatternController {

  @GetMapping("/{pattern}")
  @ResponseBody
  public String echoPattern(@PathVariable String pattern) {
    return pattern;
  }
}
