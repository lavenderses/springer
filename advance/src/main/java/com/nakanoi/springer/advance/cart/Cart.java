package com.nakanoi.springer.advance.cart;

import java.io.Serializable;
import java.util.Date;

/** Simple cart bean. */
public class Cart implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private final Date born = new Date();
  private Date lastAccess;

  public Cart() {
    lastAccess = new Date();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBorn() {
    return new Date(born.getTime());
  }

  public Date getLastAccess() {
    return new Date(lastAccess.getTime());
  }

  public void setLastAccess(Date lastAccess) {
    this.lastAccess = new Date(lastAccess.getTime());
  }
}
