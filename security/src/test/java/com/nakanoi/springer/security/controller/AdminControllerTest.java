package com.nakanoi.springer.security.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nakanoi.springer.security.config.DataSourceConfig;
import com.nakanoi.springer.security.config.WebApplicationConfig;
import com.nakanoi.springer.security.config.WebSecurityConfig;
import com.nakanoi.springer.security.config.WebServletConfig;
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

/** Simple test for admin controller. */
@ExtendWith(SpringExtension.class)
@ContextHierarchy({
  @ContextConfiguration(
      classes = {WebApplicationConfig.class, DataSourceConfig.class, WebSecurityConfig.class}),
  @ContextConfiguration(classes = {WebServletConfig.class}),
})
@WebAppConfiguration
public class AdminControllerTest {
  private final WebApplicationContext context;
  private MockMvc mockMvc;

  public AdminControllerTest(WebApplicationContext context) {
    this.context = context;
  }

  @BeforeEach
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testGetAdminWithValidUser() throws Exception {
    mockMvc.perform(get("/admin").with(user("admin").roles("ADMIN"))).andExpect(status().isOk());
  }
}
