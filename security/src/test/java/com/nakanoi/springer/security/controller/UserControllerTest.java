package com.nakanoi.springer.security.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nakanoi.springer.security.config.DataSourceConfig;
import com.nakanoi.springer.security.config.WebApplicationConfig;
import com.nakanoi.springer.security.config.WebSecurityConfig;
import com.nakanoi.springer.security.config.WebServletConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** Simple test for user controller. */
@ExtendWith(SpringExtension.class)
@ContextHierarchy({
  @ContextConfiguration(
      classes = {WebApplicationConfig.class, DataSourceConfig.class, WebSecurityConfig.class}),
  @ContextConfiguration(classes = {WebServletConfig.class}),
})
@WebAppConfiguration
public class UserControllerTest {
  private final WebApplicationContext context;
  private MockMvc mockMvc;

  public UserControllerTest(WebApplicationContext context) {
    this.context = context;
  }

  @BeforeEach
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
  }

  @Test
  public void testLoginForm() throws Exception {
    mockMvc
        .perform(formLogin().user("user").password("password"))
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/menu"))
        .andExpect(authenticated().withRoles("ADMIN", "USER"));
  }

  @Test
  @WithMockUser
  public void testFormLoginWithValidCsrf() throws Exception {
    mockMvc.perform(post("/logout").with(csrf())).andExpect(redirectedUrl("/login"));
  }

  @Test
  @WithMockUser
  public void testLogout() throws Exception {
    mockMvc
        .perform(logout())
        .andExpect(status().isFound())
        .andExpect(redirectedUrl("/login"))
        .andExpect(unauthenticated());
  }
}
