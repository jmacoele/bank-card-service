package com.nttdata.bankcardservice.exception;

/**
 * Exception class for invalid enum values.
 *
 * @author jmacoele
 * @date 2022/07/20
 */

public class UnknownEnumValueException extends RuntimeException {

  /**
   * serial version ID.
   */
  private static final long serialVersionUID = 7237604378573887304L;

  public UnknownEnumValueException(String message) {
    super(message);
  }
}
