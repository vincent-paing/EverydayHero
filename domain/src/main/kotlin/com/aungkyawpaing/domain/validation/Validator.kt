package com.aungkyawpaing.domain.validation

/**
 * Created by vincentpaing on 8/5/17.
 */
object Validator {

  private const val CASE_SUCCESS = "Success"

  private const val CASE_EMPTY_USERNAME = "Username cannot be empty"
  private const val CASE_DOUBLE_QUOTE_USERNAME = "Username cannot contain double quotes"
  private const val CASE_INVALID_USERNAME_LENGTH = "Username cannot be longer than 10 characters"
  private const val CASE_SPACE_USERNAME = "Username cannot contain space"

  private const val CASE_EMPTY_PASSWORD = "Password cannot be empty"
  private const val CASE_DOUBLE_QUOTE_PASSWORD = "Password cannot contain double quotes"
  private const val CASE_INVALID_PASSWORD_LENGTH = "Password cannot be longer than 20 characters"
  private const val CASE_PASSWORD_DIFFERENT = "Password is not the same"

  private const val CASE_EMPTY_PHONE_NO = "PhoneNo. cannot be empty"
  private const val CASE_NON_NUMERIC_PHONE_NO = "PhoneNo. cannot contain non-numeric characters"

  fun validateUserName(userName: String): ValidationResult {
    if (userName.isEmpty()) return ValidationResult(false, CASE_EMPTY_USERNAME)
    if (userName.contains("\"")) return ValidationResult(false, CASE_DOUBLE_QUOTE_USERNAME)
    if (userName.length > 10) return ValidationResult(false, CASE_INVALID_USERNAME_LENGTH)
    if (userName.contains(" ")) return ValidationResult(false, CASE_SPACE_USERNAME)
    return ValidationResult(true, CASE_SUCCESS)
  }

  fun validatePassword(password: String): ValidationResult {
    if (password.isEmpty()) return ValidationResult(false, CASE_EMPTY_PASSWORD)
    if (password.contains("\"")) return ValidationResult(false, CASE_DOUBLE_QUOTE_PASSWORD)
    if (password.length > 20) return ValidationResult(false, CASE_INVALID_PASSWORD_LENGTH)
    return ValidationResult(true, CASE_SUCCESS)
  }

  fun validatePasswordMatches(password: String, passwordAgain: String): ValidationResult {
    if (!password.equals(passwordAgain)) {
      return ValidationResult(false, CASE_PASSWORD_DIFFERENT)
    }
    return ValidationResult(true, CASE_SUCCESS)
  }


  fun validatePhoneNo(phoneNo: String): ValidationResult {
    if (phoneNo.isEmpty()) return ValidationResult(false, CASE_EMPTY_PHONE_NO)
    if (!phoneNo.matches(Regex("[0-9]+"))) return ValidationResult(false, CASE_NON_NUMERIC_PHONE_NO)
    return ValidationResult(true, CASE_SUCCESS)
  }

}