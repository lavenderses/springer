package com.nakanoi.springer.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nakanoi.springer.test.config.AppConfig;
import com.nakanoi.springer.test.config.TestServletConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

/** Simple welcome controller test. */
@ExtendWith(SpringExtension.class)
@ContextHierarchy({
  @ContextConfiguration(classes = AppConfig.class),
  @ContextConfiguration(classes = TestServletConfig.class)
})
@WebAppConfiguration
public class WelcomeControllerTest {
  WebApplicationContext context;
  MockMvc mockMvc;

  public WelcomeControllerTest(WebApplicationContext context) {
    this.context = context;
  }

  @BeforeEach
  public void setUp() throws Exception {
    mockMvc =
        MockMvcBuilders.webAppContextSetup(context)
            .addFilter(new CharacterEncodingFilter("UTF-8"))
            .build();
  }

  @Test
  public void testGetWelcome() throws Exception {
    mockMvc
        .perform(get("/welcome"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/index.jsp"));
  }
}
