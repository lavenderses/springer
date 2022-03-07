package com.nakanoi.springer.test.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

/** Simple test for message service. */
@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {
  @InjectMocks MessageService sut;
  @Mock MessageSource mockMessageSource;

  @Test
  public void testGetMessage() throws Exception {
    String actual = sut.getMessage();
    String expected = "Hello world.";

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testGetMessageByCode() throws Exception {
    String code = "greeting";
    when(mockMessageSource.getMessage(code, null, Locale.getDefault())).thenReturn("Hello world.");
    String actual = sut.getMessageByCode(code);
    String expected = "Hello world.";

    assertThat(actual).isEqualTo(expected);
  }
}
