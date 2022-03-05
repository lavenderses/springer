package com.nakanoi.springer.rest.book;

import java.io.Serializable;

/** Simple book publisher bean. */
public class PublisherResource implements Serializable, Cloneable {
  private String name;
  private String tel;

  public PublisherResource() {}

  public PublisherResource(String name, String tel) {
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
  public PublisherResource clone() {
    try {
      PublisherResource clone = (PublisherResource) super.clone();
      clone.setName(getName());
      clone.setTel(getTel());
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
