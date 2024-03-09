package cz.balikobot.api.definitions;

import java.util.Arrays;
import java.util.List;

import cz.balikobot.api.exceptions.InvalidArgumentException;

/**
 * Currencies.
 */
public enum Currency {
  /**
   * Dolar
   *
   */
  AUD("AUD"),

  /**
   * Real
   *
   */
  BRL("BRL"),

  /**
   * Lev
   *
   */
  BGN("BGN"),

  /**
   * Renminbi
   *
   */
  CNY("CNY"),

  /**
   * Koruna
   *
   */
  DKK("DKK"),

  /**
   * Euro
   *
   */
  EUR("EUR"),

  /**
   * Koruna
   *
   */
  CZK("CZK"),

  /**
   * Peso
   *
   */
  PHP("PHP"),

  /**
   * Dolar
   *
   */
  HKD("HKD"),

  /**
   * Kuna
   *
   */
  HRK("HRK"),

  /**
   * Rupie
   *
   */
  INR("INR"),

  /**
   * Rupie
   *
   */
  IDR("IDR"),

  /**
   * Šekel
   *
   */
  ILS("ILS"),

  /**
   * Jen
   *
   */
  JPY("JPY"),

  /**
   * Rand
   *
   */
  ZAR("ZAR"),

  /**
   * Won
   *
   */
  KRW("KRW"),

  /**
   * Dolar
   *
   */
  CAD("CAD"),

  /**
   * Forint
   *
   */
  HUF("HUF"),

  /**
   * Ringgit
   *
   */
  MYR("MYR"),

  /**
   * Peso
   *
   */
  MXN("MXN"),

  /**
   * SDR
   *
   */
  XDR("XDR"),

  /**
   * Koruna
   *
   */
  NOK("NOK"),

  /**
   * Dolar
   *
   */
  NZD("NZD"),

  /**
   * Zlotý
   *
   */
  PLN("PLN"),

  /**
   * Nové leu
   *
   */
  RON("RON"),

  /**
   * Rubl
   *
   */
  RUB("RUB"),

  /**
   * Dolar
   *
   */
  SGD("SGD"),

  /**
   * Koruna
   *
   */
  SEK("SEK"),

  /**
   * Frank
   *
   */
  CHF("CHF"),

  /**
   * Baht
   *
   */
  THB("THB"),

  /**
   * Lira
   *
   */
  TRY("TRY"),

  /**
   * Dolar
   *
   */
  USD("USD"),

  /**
   * Libra
   *
   */
  GBP("GBP");
  
  public final String label;

  Currency(String label) {
    this.label = label;
  }

  public static Currency valueOfLabel(String label) {
    for (Currency e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * @return ArrayList<Currency>
   */
  public static List<Currency> all()
  {
    return Arrays.asList(
    AUD,
        BRL,
        BGN,
        CNY,
        DKK,
        EUR,
        CZK,
        PHP,
        HKD,
        HRK,
        INR,
        IDR,
        ILS,
        JPY,
        ZAR,
        KRW,
        CAD,
        HUF,
        MYR,
        MXN,
        XDR,
        NOK,
        NZD,
        PLN,
        RON,
        RUB,
        SGD,
        SEK,
        CHF,
        THB,
        TRY,
        USD,
        GBP);
  }

  /**
   * Validates the given currency code.
   *
   * @param code The currency code to validate.
   * @throws InvalidArgumentException If the code is not a valid currency code.
   */
  public static void validateCode(String code) throws InvalidArgumentException {
    final Currency currencyEnum = Currency.valueOf(code);
    if (!all().contains(currencyEnum)) {
    throw new InvalidArgumentException("Invalid currency \"" + code + "\" has been entered.");
  }
  }
}
