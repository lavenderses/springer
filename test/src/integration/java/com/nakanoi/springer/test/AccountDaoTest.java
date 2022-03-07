package com.nakanoi.springer.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.nakanoi.springer.test.app.Account;
import com.nakanoi.springer.test.app.AccountDao;
import com.nakanoi.springer.test.config.AppConfig;
import com.nakanoi.springer.test.config.TestConfig;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/** Simple test for account registry. */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
@Sql("/delete.sql")
@Transactional
public class AccountDaoTest {
  AccountDao sut;
  JdbcTemplate jdbcTemplate;

  @Autowired
  public AccountDaoTest(
      AccountDao accountDao, @Qualifier("jdbcTemplateForAssertion") JdbcTemplate jdbcTemplate) {
    this.sut = accountDao;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Test
  @Sql({"/delete.sql", "/accounts-insert.sql"})
  public void testFindOne() throws Exception {
    String accountId = "001";
    Account account = sut.findOne(accountId);

    assertThat(account.getId()).isEqualTo("001");
    assertThat(account.getName()).isEqualTo("Mr. Spring");
  }

  @Test
  @Sql("/delete.sql")
  public void testCreate() throws Exception {
    String id = "XXX";
    String name = "xyz zyx";
    Account account = new Account();
    account.setId(id);
    account.setName(name);

    int record = sut.create(account);
    Map<String, Object> map =
        jdbcTemplate.queryForMap("SELECT id, name FROM itAccounts WHERE id = ?", id);

    assertThat(record).isEqualTo(1);
    assertThat((String) map.get("id")).isEqualTo(id);
    assertThat((String) map.get("name")).isEqualTo(name);
  }
}
