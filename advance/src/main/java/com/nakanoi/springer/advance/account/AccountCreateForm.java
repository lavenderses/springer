package com.nakanoi.springer.advance.account;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Simple account creation form object. */
public class AccountCreateForm implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotNull
  @Size(min = 1, max = 10)
  private String name;

  @NotNull
  @Size(min = 5, max = 255)
  private String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
