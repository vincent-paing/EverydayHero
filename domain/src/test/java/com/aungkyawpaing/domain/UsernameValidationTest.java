package com.aungkyawpaing.domain;

import com.aungkyawpaing.domain.validation.Validator;
import com.aungkyawpaing.domain.validation.ValidationResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincentpaing on 8/5/17.
 */

public class UsernameValidationTest {

  @Test public void testEmptyUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validateUserName("");
    assertEquals("Username cannot be empty", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testDoubleQuoteUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validateUserName("Vin\"cent");
    assertEquals("Username cannot contain double quotes", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testSpaceUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validateUserName("I'm a pickle!");
    assertEquals("Username cannot contain space", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testInvalidLengthUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validateUserName("VincentVanGoughVincentVanGoughVincentVanGoughVincentVanGoughVincentVanGough");
    assertEquals("Username cannot be longer than 10 characters", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testValidUserName() {
    ValidationResult validationResult = Validator.INSTANCE.validateUserName("Vincent");
    assertEquals(true, validationResult.isValid());
  }

}
