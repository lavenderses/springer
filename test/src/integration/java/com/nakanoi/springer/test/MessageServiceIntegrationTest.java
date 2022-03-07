package com.nakanoi.springer.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.nakanoi.springer.test.config.AppConfig;
import com.nakanoi.springer.test.config.LocalAppConfig;
import com.nakanoi.springer.test.domain.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/** Simple integration test for message service. */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class, LocalAppConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = "auth.failureCountToLock=3")
// @TestPropertySource(locations = "/integration.properties")
// @ActiveProfiles("local")
class MessageServiceIntegrationTest {
  @Autowired MessageService sut;

  @Test
  public void testGetMessageByCode() throws Exception {
    String actual = sut.getMessageByCode("greeting");
    String expected = "Hello world.";
    // String expected = "Hello world from local.";
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testAuthLockCount() throws Exception {
    assertThat(sut.getFailureCountLock()).isEqualTo(3);
  }
}
