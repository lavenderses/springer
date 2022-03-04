package com.nakanoi.springer.mvc.app;

import com.nakanoi.springer.mvc.validations.AlphabetNumber;
import com.nakanoi.springer.mvc.validations.EmailConfirmation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/** Simple account signup form. */
@EmailConfirmation(property = "email", targetProperty = "emailConfirmation")
public class AccountCreateForm implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotNull
  @Size(min = 1, max = 50)
  @AlphabetNumber
  private String name;

  @NotNull
  @Size(min = 9, max = 11)
  private String tel;

  @NotNull
  @Past
  @DateTimeFormat(pattern = "yyyyMMdd")
  private Date dateOfBirth;

  @NotNull
  @Size(min = 9, max = 256)
  private String email;

  @NotNull
  @Size(min = 9, max = 256)
  private String emailConfirmation;

  private List<String> roles = new ArrayList<>();

  @Valid private AccountCard card;

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

  public Date getDateOfBirth() {
    return dateOfBirth == null ? null : new Date(dateOfBirth.getTime());
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth == null ? null : new Date(dateOfBirth.getTime());
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailConfirmation() {
    return emailConfirmation;
  }

  public void setEmailConfirmation(String emailConfirmation) {
    this.emailConfirmation = emailConfirmation;
  }

  public List<String> getRoles() {
    return List.copyOf(roles);
  }

  public void setRoles(List<String> roles) {
    this.roles = List.copyOf(roles);
  }

  public AccountCard getCard() {
    return AccountCard.copyOf(card);
  }

  public void setCard(AccountCard card) {
    this.card = AccountCard.copyOf(card);
  }
}
