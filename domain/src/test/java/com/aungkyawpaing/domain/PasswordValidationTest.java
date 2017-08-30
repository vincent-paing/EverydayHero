package com.aungkyawpaing.domain;

import com.aungkyawpaing.domain.validation.Validator;
import com.aungkyawpaing.domain.validation.ValidationResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincentpaing on 8/5/17.
 */

public class PasswordValidationTest {

  @Test public void testEmptyPassword() {
    ValidationResult validationResult = Validator.INSTANCE.validatePassword("");
    assertEquals("Password cannot be empty", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testDoubleQuoteUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validatePassword("qwe123\"!@#");
    assertEquals("Password cannot contain double quotes", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testInvalidLengthUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validatePassword("VincentVanGoughVincentVanGoughVincentVanGoughVincentVanGoughVincentVanGough");
    assertEquals("Password cannot be longer than 20 characters", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testValidPassword() {
    ValidationResult validationResult = Validator.INSTANCE.validatePassword("Qwe123!@#");
    assertEquals(true, validationResult.isValid());
  }

  @Test public void testValidPasswordMatches() {
    ValidationResult validationResult =
        Validator.INSTANCE.validatePasswordMatches("Qwe123!@#", "Qwe123!@#");
    assertEquals(true, validationResult.isValid());
  }

  @Test public void testInvalidPasswordMatches() {
    ValidationResult validationResult = Validator.INSTANCE.validatePasswordMatches("qwe123!@#", "Qwe123!@#");
    assertEquals(false, validationResult.isValid());
  }

}
