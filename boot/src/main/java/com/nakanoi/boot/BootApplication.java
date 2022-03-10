package com.nakanoi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootApplication {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello world.";
  }

  public static void main(String[] args) {
    SpringApplication.run(BootApplication.class, args);
  }
}
