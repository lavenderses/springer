package com.nakanoi.springer.test.app;

import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/** Simple account dao. */
@Component
public class AccountDao {
  private final JdbcTemplate jdbcTemplate;

  public AccountDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Account findOne(String accountId) {
    String sql = "SELECT id, name FROM itAccounts WHERE id = ?";
    Map<String, Object> map = jdbcTemplate.queryForMap(sql, accountId);
    Account account = new Account();
    account.setId((String) map.get("id"));
    account.setName((String) map.get("name"));
    return account;
  }

  public int create(Account account) {
    String sql = "INSERT INTO itAccounts (id, name) VALUES (?, ?)";
    return jdbcTemplate.update(sql, account.getId(), account.getName());
  }
}
