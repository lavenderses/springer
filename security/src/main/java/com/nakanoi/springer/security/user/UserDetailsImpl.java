package com.nakanoi.springer.security.user;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** Simple user details implementation. */
public class UserDetailsImpl implements UserDetails {
  private final User user;
  private final Collection<GrantedAuthority> authorities;

  public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
    this.user = User.copyOf(user);
    this.authorities = new ArrayList<>(authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>(authorities);
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  public User getUser() {
    return User.copyOf(user);
  }
}
