package com.nakanoi.springer.mvc.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/** Simple email confirmation. */
@Documented
@Constraint(validatedBy = {EmailConfirmationValidator.class})
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface EmailConfirmation {
  String message() default "{com.nakanoi.springer.mvc.validations.EmailConfirmation.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String property();

  String targetProperty();

  @Documented
  @Target({TYPE, ANNOTATION_TYPE})
  @Retention(RUNTIME)
  public @interface List {
    EmailConfirmation[] value();
  }
}
