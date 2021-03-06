package cz.balikobot.api.definitions;

public enum Option {
  /**
   * Eshop ID
   * String
   *
   */
  EID("eid"),

  /**
   * Package number
   * int
   *
   */
  ORDER_NUMBER("order_number"),

  /**
   * Order id
   * String
   * max length 10 characters
   *
   */
  REAL_ORDER_ID("real_order_id"),

  /**
   * Service type
   * String
   *
   */
  SERVICE_TYPE("service_type"),

  /***
   * Services
   * ArrayList<>
   *
   */
  SERVICES("services"),

  /**
   * Branch id for pickup service
   * String
   *
   */
  BRANCH_ID("branch_id"),

  /***
   * Package price
   * Double
   *
   */
  PRICE("price"),

  /**
   * Insurance
   * Boolean
   *
   */
  DEL_INSURANCE("del_insurance"),

  /**
   * Insurance
   * Boolean
   *
   */
  DEL_EVENING("del_evening"),

  /**
   * Pay by customer
   * Boolean
   *
   */
  DEL_EXWORKS("del_exworks"),

  /**
   * Pay by customer
   * Boolean
   *
   */
  DEL_EXWORKS_ACCOUNT_NUMBER("del_exworks_account_number"),

  /**
   * Pay by customer
   * Boolean
   *
   */
  DEL_EXWORKS_ZIP("del_exworks_zip"),

  /**
   * Country code required for del_exworks = 4
   * String
   *
   */
  DEL_EXWORKS_COUNTRY_CODE("del_exworks_country_code"),

  /***
   * Package COD price
   * Double
   *
   */
  COD_PRICE("cod_price"),

  /**
   * Package cod currency
   * Double
   *
   */
  COD_CURRENCY("cod_currency"),

  /**
   * Variable symbol
   * Double
   *
   */
  VS("vs"),

  /**
   * Customer fullname
   *
   */
  REC_NAME("rec_name"),

  /**
   * Customer company name
   *
   */
  REC_FIRM("rec_firm"),

  /**
   * Delivery address street
   *
   */
  REC_STREET("rec_street"),

  /**
   * Delivery address city
   *
   */
  REC_CITY("rec_city"),

  /**
   * Delivery address postcode
   *
   */
  REC_ZIP("rec_zip"),

  /**
   * Delivery address region (HU,RO)
   *
   */
  REC_REGION("rec_region"),

  /**
   * Delivery address country code
   * ISO 3166-1 alpha-2 http://cs.wikipedia.org/wiki/ISO_3166-1
   *
   */
  REC_COUNTRY("rec_country"),

  /**
   * Customer email
   *
   */
  REC_EMAIL("rec_email"),

  /**
   * Customer phone
   *
   */
  REC_PHONE("rec_phone"),

  /**
   * Customer ID
   *
   */
  REC_ID("rec_id"),

  /**
   * Weight in kg
   * Double
   *
   */
  WEIGHT("weight"),

  /**
   * Currency
   *
   */
  INS_CURRENCY("ins_currency"),

  /**
   * Taking delivery requires full age
   * Boolean
   *
   */
  REQUIRE_FULL_AGE("require_full_age"),

  /**
   * Variation of age verification - send value "15" for 15+, send value "18" for 18+
   * String
   *
   */
  FULL_AGE_MINIMUM("full_age_minimum"),

  /**
   * Taking delivery requires password
   *
   */
  PASSWORD("password"),

  /**
   * Credit card
   * Boolean
   *
   */
  CREDIT_CARD("credit_card"),

  /**
   * Notifies customer by SMS
   * Boolean
   *
   */
  SMS_NOTIFICATION("sms_notification"),

  /**
   * Width in cm
   * Double
   *
   */
  WIDTH("width"),

  /**
   * Length in cm
   * Double
   *
   */
  LENGTH("length"),

  /**
   * Height in cm
   * Double
   *
   */
  HEIGHT("height"),

  /**
   * Note
   * String
   *
   */
  NOTE("note"),

  /**
   * Exchangeable package
   *
   */
  SWAP("swap"),

  /**
   * Exchangeable package
   *
   */
  SWAP_OPTION("swap_option"),

  /**
   * Delivery bills back
   * Boolean
   *
   */
  VDL_SERVICE("vdl_service"),

  /**
   * Total volume of shipment in m3
   *
   */
  VOLUME("volume"),

  /**
   * Manipulation unit code
   *
   // * @see Client.getManipulationUnits()
   *
   */
  MU_TYPE("mu_type"),

  /**
   * Number of items if bigger than one
   * int
   *
   */
  PIECES_COUNT("pieces_count"),

  /**
   * Manipulation unit code
   *
   // * @see Client.getManipulationUnits()
   *
   */
  MU_TYPE_ONE("mu_type_one"),

  /**
   * Number of items if bigger than one
   * int
   *
   */
  PIECES_COUNT_ONE("pieces_count_one"),

  /**
   * Manipulation unit code
   *
   // * @see Client.getManipulationUnits()
   *
   */
  MU_TYPE_TWO("mu_type_two"),

  /**
   * Number of items if bigger than one
   * int
   *
   */
  PIECES_COUNT_TWO("pieces_count_two"),

  /**
   * Manipulation unit code
   *
   // * @see Client.getManipulationUnits()
   *
   */
  MU_TYPE_THREE("mu_type_three"),

  /**
   * Number of items if bigger than one
   * int
   *
   */
  PIECES_COUNT_THREE("pieces_count_three"),

  /**
   * Carry to the floor and others
   * Boolean
   *
   */
  COMFORT_SERVICE("comfort_service"),

  /**
   * Carry to the floor and others
   * Boolean
   *
   */
  COMFORT_SERVICE_PLUS("comfort_plus_service"),

  /**
   * Oversize shipment
   * Boolean
   *
   */
  OVER_DIMENSION("over_dimension"),

  /**
   * Number of palettes send back (use when more than one)
   * int
   *
   */
  WRAP_BACK_COUNT("wrap_back_count"),

  /**
   * Description of returnable packaging
   * String
   *
   */
  WRAP_BACK_NOTE("wrap_back_note"),

  /**
   * Return old household appliance
   * Boolean
   *
   */
  APP_DISP("app_disp"),

  /**
   * The scheduled delivery date of the shipment is reported as date
   * String (YYYY-mm-dd)
   *
   */
  DELIVERY_DATE("delivery_date"),

  /**
   * Taking delivery requires password
   *
   */
  RETURN_TRACK("return_track"),

  /**
   * Full bank account number
   * String
   *
   */
  BANK_ACCOUNT_NUMBER("bank_account_number"),

  /**
   * Text content of the shipment
   * String
   *
   */
  CONTENT("content"),

  /**
   * Terms and Conditions
   * String
   *
   */
  TERMS_OF_TRADE("terms_of_trade"),

  /**
   * PDF in base64 String
   * String
   *
   */
  INVOICE_PDF("invoice_pdf"),

  /**
   * Year of the addressee's birth
   * String (YYYY)
   *
   */
  FULL_AGE_DATA("full_age_data"),

  /**
   * Supplementary Saturday delivery service for B2C shipments
   * Boolean
   *
   */
  SAT_DELIVERY("sat_delivery"),

  /**
   * Returning the numbers of individual pieces of cargo handling units
   * Boolean
   *
   */
  GET_PIECES_NUMBERS("get_piece_numbers"),

  /**
   * Return erros as messages
   *
   */
  RETURN_FULL_ERRORS("return_full_errors"),

  /**
   * The content of manipulation units (mu_type_one),
   * String
   *
   */
  CONTENT_ONE("content_one"),

  /**
   * The content of manipulation units (mu_type_two),
   * String
   *
   */
  CONTENT_TWO("content_two"),

  /**
   * The content of manipulation units (mu_type_three),
   * String
   *
   */
  CONTENT_THREE("content_three"),

  /**
   * Phone delivery notification
   * Boolean
   *
   */
  PHONE_DELIVERY_NOTIFICATION("phone_delivery_notification"),

  /**
   * Phone order notification
   * Boolean
   *
   */
  PHONE_ORDER_NOTIFICATION("phone_order_notification"),

  /**
   * Email notification
   * Boolean
   *
   */
  EMAIL_NOTIFICATION("email_notification"),

  /**
   * Notifies customer by phone
   * Boolean
   *
   */
  PHONE_NOTIFICATION("phone_notification"),

  /**
   * B2C service
   * Boolean
   *
   */
  B2C_NOTIFICATION("b2c_notification"),

  /**
   * Note
   *
   */
  NOTE_DRIVER("note_driver"),

  /**
   * Note for customer
   *
   */
  NOTE_CUSTOMER("note_recipient"),

  /**
   * Carry to the floor and others
   * String
   *
   */
  COMFORT_EXCLUSIVE_SERVICE("comfort_exclusive_service"),

  /**
   * Delivery to the department - floor
   * Boolean
   *
   */
  PERS_DELIVERY_FLOOR("pers_delivery_floor"),

  /**
   * Delivery to the department - building
   * String
   *
   */
  PERS_DELIVERY_BUILDING("pers_delivery_building"),

  /**
   * Delivery to the department - department
   * String
   *
   */
  PERS_DELIVERY_DEPARTMENT("pers_delivery_department"),

  /**
   * PIN
   * int
   *
   */
  PIN("pin"),

  /**
   * Data for customs clearance
   * String
   *
   */
  CONTENT_DATA("content_data"),

  /**
   * Invoice number
   *
   * String
   *
   */
  INVOICE_NUMBER("invoice_number"),

  /**
   * Customer can open the package and check the contents before taking over
   * Boolean
   *
   */
  OPEN_BEFORE_PAYMENT("open_before_payment"),

  /**
   * Customeryou can try the goods before taking them
   * Boolean
   *
   */
  TEST_BEFORE_PAYMENT("test_before_payment"),

  /**
   * ADR mode of transport
   * Boolean
   *
   */
  ADR_SERVICE("adr_service"),

  /**
   * Individual ADR items in the shipment
   * String
   *
   */
  ADR_CONTENT("adr_content"),

  /**
   * ????slo popisn??, pokud pro danou adresu neexistuje dopl??te "0"
   *
   */
  REC_HOUSE_NUMBER("rec_house_number"),

  /**
   * Identifik??tor bloku (p??en?????? se jen u p??epravce BG Speedy)
   *
   */
  REC_BLOCK("rec_block"),

  /**
   * ????slo vchodu (p??en?????? se jen u p??epravce BG Speedy)
   *
   */
  REC_ENTERANCE("rec_enterance"),

  /**
   * ????slo podla???? (p??en?????? se jen u p??epravce BG Speedy)
   *
   */
  REC_FLOOR("rec_floor"),

  /**
   * ????slo bytu / apartm??nu (p??en?????? se jen u p??epravce BG Speedy)
   *
   */
  REC_FLAT_NUMBER("rec_flat_number"),

  /**
   * Patronymum - ot??estvo (povinn?? pro p??epravce Nova Poshta)
   *
   */
  REC_NAME_PATRONYMUM("rec_name_patronymum"),

  /**
   * ID lokality
   *
   */
  REC_LOCALE_ID("rec_locale_id"),

  /**
   * Ceny p??epravy v m??n?? c??lov?? zem??
   *
   */
  DELIVERY_COSTS("delivery_costs"),

  /**
   * Ceny p??epravy v EUR
   *
   */
  DELIVERY_COSTS_EUR("delivery_costs_eur"),

  /**
   * Datum (form??t YYYY-MM-DD) pl??novan?? reallizace p??epravy
   *
   */
  PICKUP_DATE("pickup_date"),

  /**
   * Preferovan?? ??as p??epravy OD. Form??t HH:mm
   *
   */
  PICKUP_TIME_FROM("pickup_time_from"),

  /**
   * Preferovan?? ??as p??epravy DO. Form??t HH:mm
   *
   */
  PICKUP_TIME_TO("pickup_time_to"),

  /**
   * Z??kaznick?? reference, maxim??ln?? d??lka 40 alfanumerick??ch znak??.
   *
   */
  REFERENCE("reference"),

  /**
   * SMS Service (SM1) ??? SMS avizace s mo??nost?? zasl??n?? vlastn??ho textu
   *
   */
  SM1_SERVICE("sm1_service"),

  /**
   * Text SMS pro avizaci skrze sm1_service. Max d??lka 160 znak??.
   *
   */
  SM1_TEXT("sm1_text"),

  /**
   * PreAdvice Service (SM2). SMS avizace p??ed doru??en??m z??silky.
   *
   */
  SM2_SERVICE("sm2_service"),

  /**
   * Navr??cen?? trackovac??ho linku na web c??lov??ho p??epravce.
   *
   */
  RETURN_FINAL_CARRIER_ID("return_final_carrier_id"),

  /**
   * Bank code
   * String
   *
   */
  BANK_CODE("bank_code"),

  /**
   * Koment????e k deklaraci (maximalni po??et znak?? - 150)
   * String
   *
   */
  DECLARATION_COMMENTS("declaration_comments"),

  /**
   * Sleva declaration_transport_charges - cena p??epravy (maximalni po??et znak?? - 15)
   * Double
   *
   */
  DECLARATION_CHARGES_DISCOUNT("declaration_charges_discount"),

  /**
   * Cena vlastniho pripojisteni (maximalni po??et znak?? - 15)
   * Double
   *
   */
  DECLARATION_INSURANCE_CHARGES("declaration_insurance_charges"),

  /**
   * Ostatn?? n??klady (maximalni po??et znak?? - 15)
   * Double
   *
   */
  DECLARATION_OTHER_CHARGES("declaration_other_charges"),

  /**
   * N??klady za p??epravu (maximalni po??et znak?? - 15)
   * Double
   *
   */
  DECLARATION_TRANSPORT_CHARGES("declaration_transport_charges"),

  /**
   * P??eprava alkoholu - dle smlouvy s UPS
   * Boolean
   *
   */
  IS_ALCOHOL("is_alcohol"),

  /**
   * Datum vystaven?? faktury (form??t YYYY-MM-DD)
   * String
   *
   */
  CONTENT_ISSUE_DATE("content_issue_date"),

  /**
   * ????slo faktury, kter?? se v????e k produktu.
   * String
   *
   */
  CONTENT_INVOICE_NUMBER("content_invoice_number"),

  /**
   * Zp??sob proclen??, m????e obsahovat hodnoty 'own' = vlastn?? celn?? prohl????en??, 'create' nebo 'arrier'.
   * String
   *
   */
  CONTENT_EAD("content_ead"),

  /**
   * Va??e MRN, pouze pro ead = own.
   * String
   *
   */
  CONTENT_MRN("content_mrn"),

  /**
   * Dokument EAD, ??et??zec mus?? b??t base64 PDF pro spr??vn?? p??ed??n??, pouze pro ead = own
   * String
   *
   */
  EAD_PDF("ead_pdf");

  public final String label;

  Option(String label) {
    this.label = label;
  }

  public static Option valueOfLabel(String label) {
    for (Option e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

}
