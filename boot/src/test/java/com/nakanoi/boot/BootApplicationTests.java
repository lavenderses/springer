package com.nakanoi.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BootApplicationTests {

  TestRestTemplate restTemplate = new TestRestTemplate();
  @LocalServerPort int port;

  @Test
  void testHello() throws Exception {
    assertThat(restTemplate.getForObject("http://localhost:" + port, String.class))
        .isEqualTo("Hello world.");
  }
}
