package cz.balikobot.api.definitions;

import java.util.Arrays;
import java.util.List;

import cz.balikobot.api.exceptions.InvalidArgumentException;

public enum CountryEnum {
  /**
   * Afghanistan
   */
  AFGHANISTAN("AF"),

  /**
   * Aland Islands
   */
  ALAND_ISLANDS("AX"),

  /**
   * Albania
   */
  ALBANIA("AL"),

  /**
   * Algeria
   */
  ALGERIA("DZ"),

  /**
   * American Samoa
   */
  AMERICAN_SAMOA("AS"),

  /**
   * Andorra
   */
  ANDORRA("AD"),

  /**
   * Angola
   */
  ANGOLA("AO"),

  /**
   * Anguilla
   */
  ANGUILLA("AI"),

  /**
   * Antarctica
   */
  ANTARCTICA("AQ"),

  /**
   * Antigua and Barbuda
   */
  ANTIGUA_AND_BARBUDA("AG"),

  /**
   * Argentina
   */
  ARGENTINA("AR"),

  /**
   * Armenia
   */
  ARMENIA("AM"),

  /**
   * Aruba
   */
  ARUBA("AW"),

  /**
   * Australia
   */
  AUSTRALIA("AU"),

  /**
   * Austria
   */
  AUSTRIA("AT"),

  /**
   * Azerbaijan
   */
  AZERBAIJAN("AZ"),

  /**
   * Bahamas
   */
  BAHAMAS("BS"),

  /**
   * Bahrain
   */
  BAHRAIN("BH"),

  /**
   * Bangladesh
   */
  BANGLADESH("BD"),

  /**
   * Barbados
   */
  BARBADOS("BB"),

  /**
   * Belarus
   */
  BELARUS("BY"),

  /**
   * Belgium
   */
  BELGIUM("BE"),

  /**
   * Belize
   */
  BELIZE("BZ"),

  /**
   * Benin
   */
  BENIN("BJ"),

  /**
   * Bermuda
   */
  BERMUDA("BM"),

  /**
   * Bhutan
   */
  BHUTAN("BT"),

  /**
   * Bolivia (Plurinational State of)
   */
  BOLIVIA("BO"),

  /**
   * Bonaire; Sint Eustatius and Saba
   */
  BONAIRE("BQ"),

  /**
   * Bosnia and Herzegovina
   */
  BOSNIA_AND_HERZEGOVINA("BA"),

  /**
   * Botswana
   */
  BOTSWANA("BW"),

  /**
   * Bouvet Island
   */
  BOUVET_ISLAND("BV"),

  /**
   * Brazil
   */
  BRAZIL("BR"),

  /**
   * British Indian Ocean Territory
   */
  BRITISH_INDIAN_OCEAN_TERRITORY("IO"),

  /**
   * Brunei Darussalam
   */
  BRUNEI_DARUSSALAM("BN"),

  /**
   * Bulgaria
   */
  BULGARIA("BG"),

  /**
   * Burkina Faso
   */
  BURKINA_FASO("BF"), /* <*/
  /**
   * Burundi
   */
  BURUNDI("BI"),

  /**
   * Cabo Verde
   */
  CABO_VERDE("CV"),

  /**
   * Cambodia
   */
  CAMBODIA("KH"),

  /**
   * Cameroon
   */
  CAMEROON("CM"),

  /**
   * Canada
   */
  CANADA("CA"),

  /**
   * Cayman Islands
   */
  CAYMAN_ISLANDS("KY"),

  /**
   * Central African Republic
   */
  CENTRAL_AFRICAN_REPUBLIC("CF"),

  /**
   * Chad
   */
  CHAD("TD"),

  /**
   * Chile
   */
  CHILE("CL"),

  /**
   * China
   */
  CHINA("CN"),

  /**
   * Christmas Island
   */
  CHRISTMAS_ISLAND("CX"),

  /**
   * Cocos (Keeling) Islands
   */
  COCOS_ISLANDS("CC"),

  /**
   * Colombia
   */
  COLOMBIA("CO"),

  /**
   * Comoros
   */
  COMOROS("KM"),

  /**
   * Congo
   */
  CONGO("CG"),

  /**
   * Congo (Democratic Republic of the)
   */
  CONGO_DEMOCRATIC_REPUBLIC("CD"),

  /**
   * Cook Islands
   */
  COOK_ISLANDS("CK"), /* <*/
  /**
   * Costa Rica
   */
  COSTA_RICA("CR"),

  /**
   * Côte d'Ivoire
   */
  COTE_DIVOIRE("CI"),

  /**
   * Croatia
   */
  CROATIA("HR"),

  /**
   * Cuba
   */
  CUBA("CU"),

  /**
   * Curaçao
   */
  CURACAO("CW"),

  /**
   * Cyprus
   */
  CYPRUS("CY"),

  /**
   * Czech Republic
   */
  CZECH_REPUBLIC("CZ"),

  /**
   * Denmark
   */
  DENMARK("DK"),

  /**
   * Djibouti
   */
  DJIBOUTI("DJ"),

  /**
   * Dominica
   */
  DOMINICA("DM"),

  /**
   * Dominican Republic
   */
  DOMINICAN_REPUBLIC("DO"),

  /**
   * Ecuador
   */
  ECUADOR("EC"),

  /**
   * Egypt
   */
  EGYPT("EG"),

  /**
   * El Salvador
   */
  EL_SALVADOR("SV"),

  /**
   * Equatorial Guinea
   */
  EQUATORIAL_GUINEA("GQ"),

  /**
   * Eritrea
   */
  ERITREA("ER"),

  /**
   * Estonia
   */
  ESTONIA("EE"),

  /**
   * Ethiopia
   */
  ETHIOPIA("ET"),

  /**
   * Falkland Islands (Malvinas)
   */
  FALKLAND_ISLANDS("FK"),

  /**
   * Faroe Islands
   */
  FAROE_ISLANDS("FO"),

  /**
   * Fiji
   */
  FIJI("FJ"),

  /**
   * Finland
   */
  FINLAND("FI"),

  /**
   * France
   */
  FRANCE("FR"),

  /**
   * French Guiana
   */
  FRENCH_GUIANA("GF"),

  /**
   * French Polynesia
   */
  FRENCH_POLYNESIA("PF"),

  /**
   * French Southern Territories
   */
  FRENCH_SOUTHERN_TERRITORIES("TF"),

  /**
   * Gabon
   */
  GABON("GA"),

  /**
   * Gambia
   */
  GAMBIA("GM"),

  /**
   * Georgia
   */
  GEORGIA("GE"),

  /**
   * Germany
   */
  GERMANY("DE"),

  /**
   * Ghana
   */
  GHANA("GH"),

  /**
   * Gibraltar
   */
  GIBRALTAR("GI"),

  /**
   * Greece
   */
  GREECE("GR"),

  /**
   * Greenland
   */
  GREENLAND("GL"),

  /**
   * Grenada
   */
  GRENADA("GD"),

  /**
   * Guadeloupe
   */
  GUADELOUPE("GP"),

  /**
   * Guam
   */
  GUAM("GU"),

  /**
   * Guatemala
   */
  GUATEMALA("GT"),

  /**
   * Guernsey
   */
  GUERNSEY("GG"),

  /**
   * Guinea
   */
  GUINEA("GN"),

  /**
   * Guinea-Bissau
   */
  GUINEA_BISSAU("GW"),

  /**
   * Guyana
   */
  GUYANA("GY"),

  /**
   * Haiti
   */
  HAITI("HT"),

  /**
   * Heard Island and McDonald Islands
   */
  HEARD_ISLAND_AND_MCDONALD_ISLANDS("HM"),

  /**
   * Holy See
   */
  HOLY_SEE("VA"),

  /**
   * Honduras
   */
  HONDURAS("HN"),

  /**
   * Hong Kong
   */
  HONG_KONG("HK"),

  /**
   * Hungary
   */
  HUNGARY("HU"),

  /**
   * Iceland
   */
  ICELAND("IS"),

  /**
   * India
   */
  INDIA("IN"),

  /**
   * Indonesia
   */
  INDONESIA("ID"),

  /**
   * Iran (Islamic Republic of)
   */
  IRAN("IR"),

  /**
   * Iraq
   */
  IRAQ("IQ"),

  /**
   * Ireland
   */
  IRELAND("IE"),

  /**
   * Isle of Man
   */
  ISLE_OF_MAN("IM"),

  /**
   * Israel
   */
  ISRAEL("IL"),

  /**
   * Italy
   */
  ITALY("IT"),

  /**
   * Jamaica
   */
  JAMAICA("JM"),

  /**
   * Japan
   */
  JAPAN("JP"),

  /**
   * Jersey
   */
  JERSEY("JE"),

  /**
   * Jordan
   */
  JORDAN("JO"),

  /**
   * Kazakhstan
   */
  KAZAKHSTAN("KZ"),

  /**
   * Kenya
   */
  KENYA("KE"),

  /**
   * Kiribati
   */
  KIRIBATI("KI"),

  /**
   * Korea (Democratic People's Republic of)
   */
  KOREA("KP"),

  /**
   * Korea (Republic of)
   */
  KOREA_REPUBLIC("KR"),

  /**
   * Kuwait
   */
  KUWAIT("KW"),

  /**
   * Kyrgyzstan
   */
  KYRGYZSTAN("KG"),

  /**
   * Lao People's Democratic Republic
   */
  LAO("LA"),

  /**
   * Latvia
   */
  LATVIA("LV"),

  /**
   * Lebanon
   */
  LEBANON("LB"),

  /**
   * Lesotho
   */
  LESOTHO("LS"),

  /**
   * Liberia
   */
  LIBERIA("LR"),

  /**
   * Libya
   */
  LIBYA("LY"),

  /**
   * Liechtenstein
   */
  LIECHTENSTEIN("LI"),

  /**
   * Lithuania
   */
  LITHUANIA("LT"),

  /**
   * Luxembourg
   */
  LUXEMBOURG("LU"),

  /**
   * Macao
   */
  MACAO("MO"),

  /**
   * Macedonia (the former Yugoslav Republic of)
   */
  MACEDONIA("MK"),

  /**
   * Madagascar
   */
  MADAGASCAR("MG"),

  /**
   * Malawi
   */
  MALAWI("MW"),

  /**
   * Malaysia
   */
  MALAYSIA("MY"),

  /**
   * Maldives
   */
  MALDIVES("MV"),

  /**
   * Mali
   */
  MALI("ML"),

  /**
   * Malta
   */
  MALTA("MT"),

  /**
   * Marshall Islands
   */
  MARSHALL_ISLANDS("MH"),

  /**
   * Martinique
   */
  MARTINIQUE("MQ"),

  /**
   * Mauritania
   */
  MAURITANIA("MR"),

  /**
   * Mauritius
   */
  MAURITIUS("MU"),

  /**
   * Mayotte
   */
  MAYOTTE("YT"),

  /**
   * Mexico
   */
  MEXICO("MX"),

  /**
   * Micronesia (Federated States of)
   */
  MICRONESIA("FM"),

  /**
   * Moldova (Republic of)
   */
  MOLDOVA("MD"),

  /**
   * Monaco
   */
  MONACO("MC"),

  /**
   * Mongolia
   */
  MONGOLIA("MN"),

  /**
   * Montenegro
   */
  MONTENEGRO("ME"),

  /**
   * Montserrat
   */
  MONTSERRAT("MS"),

  /**
   * Morocco
   */
  MOROCCO("MA"),

  /**
   * Mozambique
   */
  MOZAMBIQUE("MZ"),

  /**
   * Myanmar
   */
  MYANMAR("MM"),

  /**
   * Namibia
   */
  NAMIBIA("NA"),

  /**
   * Nauru
   */
  NAURU("NR"),

  /**
   * Nepal
   */
  NEPAL("NP"),

  /**
   * Netherlands
   */
  NETHERLANDS("NL"),

  /**
   * New Caledonia
   */
  NEW_CALEDONIA("NC"),

  /**
   * New Zealand
   */
  NEW_ZEALAND("NZ"),

  /**
   * Nicaragua
   */
  NICARAGUA("NI"),

  /**
   * Niger
   */
  NIGER("NE"),

  /**
   * Nigeria
   */
  NIGERIA("NG"),

  /**
   * Niue
   */
  NIUE("NU"),

  /**
   * Norfolk Island
   */
  NORFOLK_ISLAND("NF"),

  /**
   * Northern Mariana Islands
   */
  NORTHERN_MARIANA_ISLANDS("MP"), /* <*/
  /**
   * Norway
   */
  NORWAY("NO"),

  /**
   * Oman
   */
  OMAN("OM"),

  /**
   * Pakistan
   */
  PAKISTAN("PK"),

  /**
   * Palau
   */
  PALAU("PW"),

  /**
   * Palestine; State of
   */
  PALESTINE("PS"),

  /**
   * Panama
   */
  PANAMA("PA"),

  /**
   * Papua New Guinea
   */
  PAPUA_NEW_GUINEA("PG"),

  /**
   * Paraguay
   */
  PARAGUAY("PY"),

  /**
   * Peru
   */
  PERU("PE"),

  /**
   * Philippines
   */
  PHILIPPINES("PH"),

  /**
   * Pitcairn
   */
  PITCAIRN("PN"),

  /**
   * Poland
   */
  POLAND("PL"),

  /**
   * Portugal
   */
  PORTUGAL("PT"),

  /**
   * Puerto Rico
   */
  PUERTO_RICO("PR"),

  /**
   * Qatar
   */
  QATAR("QA"),

  /**
   * Réunion
   */
  REUNION("RE"),

  /**
   * Romania
   */
  ROMANIA("RO"),

  /**
   * Russian Federation
   */
  RUSSIAN_FEDERATION("RU"), /* <*/
  /**
   * Rwanda
   */
  RWANDA("RW"),

  /**
   * Saint Barthélemy
   */
  SAINT_BARTHELEMY("BL"),

  /**
   * Saint Helena; Ascension and Tristan da Cunha
   */
  SAINT_HELENA("SH"),

  /**
   * Saint Kitts and Nevis
   */
  SAINT_KITTS_AND_NEVIS("KN"),

  /**
   * Saint Lucia
   */
  SAINT_LUCIA("LC"),

  /**
   * Saint Martin (French part)
   */
  SAINT_MARTIN("MF"),

  /**
   * Saint Pierre and Miquelon
   */
  SAINT_PIERRE_AND_MIQUELON("PM"),

  /**
   * Saint Vincent and the Grenadines
   */
  SAINT_VINCENT_AND_THE_GRENADINES("VC"),

  /**
   * Samoa
   */
  SAMOA("WS"),

  /**
   * San Marino
   */
  SAN_MARINO("SM"),

  /**
   * Sao Tome and Principe
   */
  SAO_TOME_AND_PRINCIPE("ST"),

  /**
   * Saudi Arabia
   */
  SAUDI_ARABIA("SA"),

  /**
   * Senegal
   */
  SENEGAL("SN"),

  /**
   * Serbia
   */
  SERBIA("RS"),

  /**
   * Seychelles
   */
  SEYCHELLES("SC"),

  /**
   * Sierra Leone
   */
  SIERRA_LEONE("SL"),

  /**
   * Singapore
   */
  SINGAPORE("SG"),

  /**
   * Sint Maarten (Dutch part)
   */
  SINT_MAARTEN("SX"),

  /**
   * Slovakia
   */
  SLOVAKIA("SK"),

  /**
   * Slovenia
   */
  SLOVENIA("SI"),

  /**
   * Solomon Islands
   */
  SOLOMON_ISLANDS("SB"),

  /**
   * Somalia
   */
  SOMALIA("SO"),

  /**
   * South Africa
   */
  SOUTH_AFRICA("ZA"),

  /**
   * South Georgia and the South Sandwich Islands
   */
  SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("GS"),

  /**
   * South Sudan
   */
  SOUTH_SUDAN("SS"),

  /**
   * Spain
   */
  SPAIN("ES"),

  /**
   * Sri Lanka
   */
  SRI_LANKA("LK"),

  /**
   * Sudan
   */
  SUDAN("SD"),

  /**
   * Suriname
   */
  SURINAME("SR"),

  /**
   * Svalbard and Jan Mayen
   */
  SVALBARD_AND_JAN_MAYEN("SJ"),

  /**
   * Swaziland
   */
  SWAZILAND("SZ"),

  /**
   * Sweden
   */
  SWEDEN("SE"),

  /**
   * Switzerland
   */
  SWITZERLAND("CH"),

  /**
   * Syrian Arab Republic
   */
  SYRIAN_ARAB_REPUBLIC("SY"),

  /**
   * Taiwan; Province of China[a]
   */
  TAIWAN("TW"),

  /**
   * Tajikistan
   */
  TAJIKISTAN("TJ"),

  /**
   * Tanzania; United Republic of
   */
  TANZANIA("TZ"),

  /**
   * Thailand
   */
  THAILAND("TH"),

  /**
   * Timor-Leste
   */
  TIMOR_LESTE("TL"),

  /**
   * Togo
   */
  TOGO("TG"),

  /**
   * Tokelau
   */
  TOKELAU("TK"),

  /**
   * Tonga
   */
  TONGA("TO"),

  /**
   * Trinidad and Tobago
   */
  TRINIDAD_AND_TOBAGO("TT"), /* <*/
  /**
   * Tunisia
   */
  TUNISIA("TN"),

  /**
   * Turkey
   */
  TURKEY("TR"),

  /**
   * Turkmenistan
   */
  TURKMENISTAN("TM"),

  /**
   * Turks and Caicos Islands
   */
  TURKS_AND_CAICOS_ISLANDS("TC"),

  /**
   * Tuvalu
   */
  TUVALU("TV"),

  /**
   * Uganda
   */
  UGANDA("UG"),

  /**
   * Ukraine
   */
  UKRAINE("UA"),

  /**
   * United Arab Emirates
   */
  UNITED_ARAB_EMIRATES("AE"),

  /**
   * United Kingdom of Great Britain and Northern Ireland
   */
  UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND("GB"),

  /**
   * United States of America
   */
  UNITED_STATES_OF_AMERICA("US"),

  /**
   * United States Minor Outlying Islands
   */
  UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM"),

  /**
   * Uruguay
   */
  URUGUAY("UY"),

  /**
   * Uzbekistan
   */
  UZBEKISTAN("UZ"),

  /**
   * Vanuatu
   */
  VANUATU("VU"),

  /**
   * Venezuela (Bolivarian Republic of)
   */
  VENEZUELA("VE"),

  /**
   * Vietnam
   */
  VIETNAM("VN"),

  /**
   * Virgin Islands (British)
   */
  VIRGIN_ISLANDS_BRITISH("VG"),

  /**
   * Virgin Islands (U.S.)
   */
  VIRGIN_ISLANDS_US("VI"),

  /**
   * Wallis and Futuna
   */
  WALLIS_AND_FUTUNA("WF"),

  /**
   * Western Sahara
   */
  WESTERN_SAHARA("EH"),

  /**
   * Yemen
   */
  YEMEN("YE"),

  /**
   * Zambia
   */
  ZAMBIA("ZM"),

  /**
   * Zimbabwe
   */
  ZIMBABWE("ZW");

  public final String label;

  CountryEnum(String label) {
    this.label = label;
  }

  public static CountryEnum valueOfLabel(String label) {
    for (CountryEnum e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * Countries
   *
   * @return ArrayList<String>
   */
  public static List<CountryEnum> all() {
    return Arrays.asList(
        AFGHANISTAN,
        ALAND_ISLANDS,
        ALBANIA,
        ALGERIA,
        AMERICAN_SAMOA,
        ANDORRA,
        ANGOLA,
        ANGUILLA,
        ANTARCTICA,
        ANTIGUA_AND_BARBUDA,
        ARGENTINA,
        ARMENIA,
        ARUBA,
        AUSTRALIA,
        AUSTRIA,
        AZERBAIJAN,
        BAHAMAS,
        BAHRAIN,
        BANGLADESH,
        BARBADOS,
        BELARUS,
        BELGIUM,
        BELIZE,
        BENIN,
        BERMUDA,
        BHUTAN,
        BOLIVIA,
        BONAIRE,
        BOSNIA_AND_HERZEGOVINA,
        BOTSWANA,
        BOUVET_ISLAND,
        BRAZIL,
        BRITISH_INDIAN_OCEAN_TERRITORY,
        BRUNEI_DARUSSALAM,
        BULGARIA,
        BURKINA_FASO,
        BURUNDI,
        CABO_VERDE,
        CAMBODIA,
        CAMEROON,
        CANADA,
        CAYMAN_ISLANDS,
        CENTRAL_AFRICAN_REPUBLIC,
        CHAD,
        CHILE,
        CHINA,
        CHRISTMAS_ISLAND,
        COCOS_ISLANDS,
        COLOMBIA,
        COMOROS,
        CONGO,
        CONGO_DEMOCRATIC_REPUBLIC,
        COOK_ISLANDS,
        COSTA_RICA,
        COTE_DIVOIRE,
        CROATIA,
        CUBA,
        CURACAO,
        CYPRUS,
        CZECH_REPUBLIC,
        DENMARK,
        DJIBOUTI,
        DOMINICA,
        DOMINICAN_REPUBLIC,
        ECUADOR,
        EGYPT,
        EL_SALVADOR,
        EQUATORIAL_GUINEA,
        ERITREA,
        ESTONIA,
        ETHIOPIA,
        FALKLAND_ISLANDS,
        FAROE_ISLANDS,
        FIJI,
        FINLAND,
        FRANCE,
        FRENCH_GUIANA,
        FRENCH_POLYNESIA,
        FRENCH_SOUTHERN_TERRITORIES,
        GABON,
        GAMBIA,
        GEORGIA,
        GERMANY,
        GHANA,
        GIBRALTAR,
        GREECE,
        GREENLAND,
        GRENADA,
        GUADELOUPE,
        GUAM,
        GUATEMALA,
        GUERNSEY,
        GUINEA,
        GUINEA_BISSAU,
        GUYANA,
        HAITI,
        HEARD_ISLAND_AND_MCDONALD_ISLANDS,
        HOLY_SEE,
        HONDURAS,
        HONG_KONG,
        HUNGARY,
        ICELAND,
        INDIA,
        INDONESIA,
        IRAN,
        IRAQ,
        IRELAND,
        ISLE_OF_MAN,
        ISRAEL,
        ITALY,
        JAMAICA,
        JAPAN,
        JERSEY,
        JORDAN,
        KAZAKHSTAN,
        KENYA,
        KIRIBATI,
        KOREA,
        KOREA_REPUBLIC,
        KUWAIT,
        KYRGYZSTAN,
        LAO,
        LATVIA,
        LEBANON,
        LESOTHO,
        LIBERIA,
        LIBYA,
        LIECHTENSTEIN,
        LITHUANIA,
        LUXEMBOURG,
        MACAO,
        MACEDONIA,
        MADAGASCAR,
        MALAWI,
        MALAYSIA,
        MALDIVES,
        MALI,
        MALTA,
        MARSHALL_ISLANDS,
        MARTINIQUE,
        MAURITANIA,
        MAURITIUS,
        MAYOTTE,
        MEXICO,
        MICRONESIA,
        MOLDOVA,
        MONACO,
        MONGOLIA,
        MONTENEGRO,
        MONTSERRAT,
        MOROCCO,
        MOZAMBIQUE,
        MYANMAR,
        NAMIBIA,
        NAURU,
        NEPAL,
        NETHERLANDS,
        NEW_CALEDONIA,
        NEW_ZEALAND,
        NICARAGUA,
        NIGER,
        NIGERIA,
        NIUE,
        NORFOLK_ISLAND,
        NORTHERN_MARIANA_ISLANDS,
        NORWAY,
        OMAN,
        PAKISTAN,
        PALAU,
        PALESTINE,
        PANAMA,
        PAPUA_NEW_GUINEA,
        PARAGUAY,
        PERU,
        PHILIPPINES,
        PITCAIRN,
        POLAND,
        PORTUGAL,
        PUERTO_RICO,
        QATAR,
        REUNION,
        ROMANIA,
        RUSSIAN_FEDERATION,
        RWANDA,
        SAINT_BARTHELEMY,
        SAINT_HELENA,
        SAINT_KITTS_AND_NEVIS,
        SAINT_LUCIA,
        SAINT_MARTIN,
        SAINT_PIERRE_AND_MIQUELON,
        SAINT_VINCENT_AND_THE_GRENADINES,
        SAMOA,
        SAN_MARINO,
        SAO_TOME_AND_PRINCIPE,
        SAUDI_ARABIA,
        SENEGAL,
        SERBIA,
        SEYCHELLES,
        SIERRA_LEONE,
        SINGAPORE,
        SINT_MAARTEN,
        SLOVAKIA,
        SLOVENIA,
        SOLOMON_ISLANDS,
        SOMALIA,
        SOUTH_AFRICA,
        SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS,
        SOUTH_SUDAN,
        SPAIN,
        SRI_LANKA,
        SUDAN,
        SURINAME,
        SVALBARD_AND_JAN_MAYEN,
        SWAZILAND,
        SWEDEN,
        SWITZERLAND,
        SYRIAN_ARAB_REPUBLIC,
        TAIWAN,
        TAJIKISTAN,
        TANZANIA,
        THAILAND,
        TIMOR_LESTE,
        TOGO,
        TOKELAU,
        TONGA,
        TRINIDAD_AND_TOBAGO,
        TUNISIA,
        TURKEY,
        TURKMENISTAN,
        TURKS_AND_CAICOS_ISLANDS,
        TUVALU,
        UGANDA,
        UKRAINE,
        UNITED_ARAB_EMIRATES,
        UNITED_KINGDOM_OF_GREAT_BRITAIN_AND_NORTHERN_IRELAND,
        UNITED_STATES_OF_AMERICA,
        UNITED_STATES_MINOR_OUTLYING_ISLANDS,
        URUGUAY,
        UZBEKISTAN,
        VANUATU,
        VENEZUELA,
        VIETNAM,
        VIRGIN_ISLANDS_BRITISH,
        VIRGIN_ISLANDS_US,
        WALLIS_AND_FUTUNA,
        WESTERN_SAHARA,
        YEMEN,
        ZAMBIA,
        ZIMBABWE
        );
  }

  /**
   * Validate country code
   *
   * @param code
   * @return void
   * @throws \InvalidArgumentException
   */
  public static void validateCode(String code) throws InvalidArgumentException {
    final CountryEnum countryEnum = CountryEnum.valueOf(code);
    if (!all().contains(countryEnum)) {
      throw new InvalidArgumentException("Unknown country \"" + code + "\".");
    }
  }
}
