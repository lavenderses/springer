package com.nakanoi.springer.mvc.app;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/** Simple echo form. */
public class EchoForm implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotEmpty
  @Size(max = 100)
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
