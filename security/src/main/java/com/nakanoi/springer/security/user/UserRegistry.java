package com.nakanoi.springer.security.user;

import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** Simple user registry class. */
@Repository
public class UserRegistry {
  private final JdbcTemplate jdbcTemplate;

  public UserRegistry(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public User findOne(String username) {
    String sql = "SELECT username, password, isEnabled, isAdmin FROM securities WHERE username = ?";
    Map<String, Object> map = jdbcTemplate.queryForMap(sql, username);
    if (map.size() == 0) {
      return null;
    }
    User user = new User();
    user.setUsername((String) map.get("username"));
    user.setPassword((String) map.get("password"));
    user.setEnabled((boolean) map.get("isEnabled"));
    user.setAdmin((boolean) map.get("isAdmin"));
    return user;
  }
}
