package com.nakanoi.springer.security.user;

import java.io.Serializable;

public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private String username;
  private String password;
  private boolean isEnabled;
  private boolean isAdmin;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  static User copyOf(User user) {
    User copy = new User();
    copy.setUsername(user.getUsername());
    copy.setPassword(user.getPassword());
    copy.setEnabled(user.isEnabled());
    copy.setAdmin(user.isAdmin());
    return copy;
  }
}
