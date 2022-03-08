package com.nakanoi.springer.security.user;

import java.util.Collection;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Simple user details service implementation. */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRegistry userRegistry;

  public UserDetailsServiceImpl(UserRegistry userRegistry) {
    this.userRegistry = userRegistry;
  }

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =
        Optional.ofNullable(userRegistry.findOne(username))
            .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    return new UserDetailsImpl(user, getAuthorities(user));
  }

  private Collection<GrantedAuthority> getAuthorities(User user) {
    String[] roles =
        user.isAdmin() ? new String[] {"ROLE_USER", "ROLE_ADMIN"} : new String[] {"ROLE_USER"};
    return AuthorityUtils.createAuthorityList(roles);
  }
}
