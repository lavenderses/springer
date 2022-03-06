package com.nakanoi.springer.rest.book;

import java.io.Serializable;

/** Simple publisher class. */
public class Publisher implements Cloneable, Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String tel;

  public Publisher(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  @Override
  public Publisher clone() {
    try {
      Publisher clone = (Publisher) super.clone();
      clone.setName(getName());
      clone.setTel(getTel());
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
