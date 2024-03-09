package cz.balikobot.api.definitions;

import java.util.Arrays;
import java.util.List;

/**
 * Balikobot shippers.
 */
public enum Shipper {
  /**
   * Česká pošta
   */
  CP("cp"),

  /**
   * DPD
   */
  DPD("dpd"),

  /**
   * DHL Express
   */
  DHL("dhl"),

  /**
   * Geis Cargo - paletová přeprava
   */
  GEIS("geis"),

  /**
   * GLS
   */
  GLS("gls"),

  /**
   * WE DO
   */
  INTIME("intime"),

  /**
   * Pošta bez hranic
   */
  PBH("pbh"),

  /**
   * PPL + DHL Freight
   */
  PPL("ppl"),

  /**
   * Slovenská pošta
   */
  SP("sp"),

  /**
   * Slovak Parcel Service
   */
  SPS("sps"),

  /**
   * Toptrans
   */
  TOPTRANS("toptrans"),

  /**
   * WE DO - Uloženka
   */
  ULOZENKA("ulozenka"),

  /**
   * UPS
   */
  UPS("ups"),

  /**
   * Zásilkovna
   */
  ZASILKOVNA("zasilkovna"),

  /**
   * TNT
   */
  TNT("tnt"),

  /**
   * Gebrüder Weiss Slovensko
   */
  GW("gw"),

  /**
   * Gebrüder Weiss Česká republika
   */
  GWCZ("gwcz"),

  /**
   * Messenger
   */
  MESSENGER("messenger"),

  /**
   * DHL DE
   */
  DHLDE("dhlde"),

  /**
   * FedEx
   */
  FEDEX("fedex"),

  /**
   * Fofr
   */
  FOFR("fofr"),

  /**
   * Dachser
   */
  DACHSER("dachser"),

  /**
   * DHL Parcel Europe - PPL Parcel Connect EU
   */
  DHLPARCEL("dhlparcel"),

  /**
   * Raben
   */
  RABEN("raben"),

  /**
   * Spring
   */
  SPRING("spring"),

  /**
   * Spring
   */
  DSV("dsv"),

  /**
   * DHL Freight Euroconnect
   */
  DHLFREIGHTEC("dhlfreightec"),

  /**
   * 123kurier
   */
  KURIER("kurier"),

  /**
   * DB Schenker
   */
  DBSCHENKER("dbschenker"),

  /**
   * AIRWAY
   */
  AIRWAY("airway");

  public final String label;

  Shipper(String label) {
    this.label = label;
  }

  public static Shipper valueOfLabel(String label) {
    for (Shipper e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * All supported shipper services.
   *
   * @return ArrayList<String>
   */
  public static List<Shipper> all() {
    return Arrays.asList(
        CP,
        DHL,
        DPD,
        GEIS,
        GLS,
        INTIME,
        PBH,
        PPL,
        SP,
        SPS,
        TOPTRANS,
        ULOZENKA,
        UPS,
        ZASILKOVNA,
        TNT,
        GW,
        GWCZ,
        MESSENGER,
        DHLDE,
        FEDEX,
        FOFR,
        DACHSER,
        DHLPARCEL,
        RABEN,
        SPRING,
        DSV,
        DHLFREIGHTEC,
        KURIER,
        DBSCHENKER,
        AIRWAY
    );
  }

  /**
   * Validates the given shipper code. Throws an exception if the shipper code is invalid.
   *
   * @param code the shipper code to validate
   * @throws Exception if the shipper code is invalid
   */
  public static void validateCode(String code) throws Exception {
    final Shipper shipperCodeEnum = Shipper.valueOfLabel(code);
    if (!all().contains(shipperCodeEnum)) {
      throw new Exception("Unknown shipper \"" + code + "\".");
    }
  }

  /**
   * Checks if the given shipper and service codes have full branches support.
   *
   * @param shipperCode The shipper code.
   * @param serviceCode The service code.
   * @return true if the shipper and service codes have full branches support, false otherwise.
   */
  public static Boolean hasFullBranchesSupport(String shipperCode, String serviceCode) {
    final ServiceType serviceCodeEnum = ServiceType.valueOfLabel(serviceCode);
    final Shipper shipperCodeEnum = Shipper.valueOfLabel(shipperCode);

    if (shipperCodeEnum != null && shipperCodeEnum.equals(ZASILKOVNA)) {
      return true;
    }

    if (shipperCodeEnum != null && serviceCodeEnum != null && shipperCodeEnum.equals(CP) && serviceCodeEnum.equals(ServiceType.CP_NP)) {
      return true;
    }

    List<ServiceType> services = Arrays.asList(ServiceType.PBH_MP, ServiceType.PBH_FAN_KURIER);

    return shipperCodeEnum != null && shipperCodeEnum.equals(PBH) && services.contains(serviceCodeEnum);
  }

  /**
   * Checks if the given shipper and service codes support branch filtering by country.
   *
   * @param shipperCode The code of the shipper.
   * @param serviceCode The code of the service.
   * @return {@code true} if the shipper and service support branch filtering by country, {@code false} otherwise.
   */
  public static Boolean hasBranchCountryFilterSupport(String shipperCode, String serviceCode) {
    if (serviceCode == null) {
      return true;
    }
    final ServiceType serviceCodeEnum = ServiceType.valueOfLabel(serviceCode);
    final Shipper shipperCodeEnum = Shipper.valueOfLabel(shipperCode);

    List<Shipper> supportedShippers = Arrays.asList(
        PPL,
        DPD,
        GEIS,
        GLS
    );

    return supportedShippers.contains(shipperCodeEnum);
  }
}
