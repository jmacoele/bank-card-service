package com.nttdata.bankcardservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nttdata.bankcardservice.exception.UnknownEnumValueException;
/**
 * Card Type Enum.
 *
 * @author jmacoele
 *
 */

public enum CardTypeEnum {
  PERSONAL("P"),
  ENTERPRISE("E");

  private String value;

  @JsonValue
  public String getValue() {
    return value;
  }

  /**
   * Function of that convert string value into Enum value.
   *
   * @param value Enum value string*converted.
   * @return CreditCardTypeEnum
   */
  @JsonCreator
  public static CardTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (CardTypeEnum item : CardTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new UnknownEnumValueException("CreditTypeEnum: unknown value: " + value);
  }

  CardTypeEnum(String value) {
    this.value = value;
  }

}