package com.nakanoi.boot.domain;

import java.io.Serializable;

/** Simple message class. */
public class Message implements Serializable {
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
