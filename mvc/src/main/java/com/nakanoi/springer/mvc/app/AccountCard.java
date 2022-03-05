package com.nakanoi.springer.mvc.app;

import com.nakanoi.springer.mvc.validations.AlphabetNumber;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;

/** Simple account card. */
public class AccountCard implements Serializable {
  private static final long serialVersionUID = 1L;

  interface FreeAccount extends Default {}

  interface PaymentAccount extends Default {}

  @NotNull
  @Size(min = 1, max = 1)
  private String type;

  @Size.List({
    @Size(max = 0, groups = FreeAccount.class),
    @Size(min = 16, max = 16, groups = PaymentAccount.class)
  })
  @AlphabetNumber(groups = PaymentAccount.class)
  private String cardNumber;

  @Null(groups = FreeAccount.class)
  @NotNull(groups = PaymentAccount.class)
  @Future(groups = PaymentAccount.class)
  @DateTimeFormat(pattern = "yyyyMMdd")
  private Date validMonth;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Date getValidMonth() {
    return validMonth == null ? null : new Date(validMonth.getTime());
  }

  public void setValidMonth(Date validMonth) {
    this.validMonth = validMonth == null ? null : new Date(validMonth.getTime());
  }
}
