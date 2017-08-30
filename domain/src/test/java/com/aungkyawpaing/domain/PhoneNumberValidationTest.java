package com.aungkyawpaing.domain;

import com.aungkyawpaing.domain.validation.ValidationResult;
import com.aungkyawpaing.domain.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vincentpaing on 8/5/17.
 */

public class PhoneNumberValidationTest {

  @Test public void testEmptyPhoneNo() {
    ValidationResult validationResult = Validator.INSTANCE.validatePhoneNo("");
    assertEquals("PhoneNo. cannot be empty", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }

  @Test public void testNonNumericPhoneNo() {
    ValidationResult validationResult = Validator.INSTANCE.validatePhoneNo("Vin\"cent123");
    assertEquals("PhoneNo. cannot contain non-numeric characters", validationResult.getMessage());
    assertEquals(false, validationResult.isValid());
  }


  @Test public void testValidPhoneNoOne() {
    ValidationResult validationResult = Validator.INSTANCE.validatePhoneNo("091234567");
    assertEquals(true, validationResult.isValid());
  }

}
