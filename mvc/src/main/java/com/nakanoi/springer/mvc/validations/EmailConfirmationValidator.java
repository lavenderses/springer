package com.nakanoi.springer.mvc.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

/** Simple email confirmation validator. */
public class EmailConfirmationValidator implements ConstraintValidator<EmailConfirmation, Object> {
  private String property;
  private String targetProperty;
  private String message;

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    BeanWrapper wrapper = new BeanWrapperImpl(value);
    Object propertyValue = wrapper.getPropertyValue(property);
    Object targetPropertyValue = wrapper.getPropertyValue(targetProperty);
    boolean matched = ObjectUtils.nullSafeEquals(propertyValue, targetPropertyValue);
    if (matched) {
      return true;
    } else {
      context.disableDefaultConstraintViolation();
      context
          .buildConstraintViolationWithTemplate(message)
          .addPropertyNode(property)
          .addConstraintViolation();
      return false;
    }
  }

  @Override
  public void initialize(EmailConfirmation constraintAnnotation) {
    this.property = constraintAnnotation.property();
    this.targetProperty = constraintAnnotation.targetProperty();
    this.message = constraintAnnotation.message();
  }
}
