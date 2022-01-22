package cz.balikobot.api.definitions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public enum ServiceType {
  /**
   * Balík do ruky
   */
  CP_DR("DR"),

  /**
   * Doporučená zásilka Ekonomická
   */
  CP_RR("RR"),

  /**
   * Balík Na poštu
   */
  CP_NP("NP"),

  /**
   * Balík do ruky pro vybrané podavatele
   */
  CP_DV("DV"),

  /**
   * Cenné psaní
   */
  CP_VL("VL"),

  /**
   * Doporučená zásilka Ekonomická - standard
   */
  CP_SR("SR"),

  /**
   * Doporučená zásilka Prioritní
   */
  CP_RRP("RRP"),

  /**
   * Doporučená zásilka Prioritní - standard
   */
  CP_SRP("SRP"),

  /**
   * Doporučený balíček
   */
  CP_BA("BA"),

  /**
   * Cenný balík
   */
  CP_BB("BB"),

  /**
   * Balík nadrozměr
   */
  CP_BN("BN"),

  /**
   * Balík do balíkovny
   */
  CP_NB("NB"),

  /**
   * DE balík Do ruky s garantovaným časem dodání
   */
  CP_DT("DT"),

  /**
   * Balík Do ruky s garantovaným časem dodání v neděli nebo svátek
   */
  CP_DS("DS"),

  /**
   * EMS expresní přeprava po ČR
   */
  CP_EE("EE"),

  /**
   * Balík Expres
   */
  CP_BE("BE"),

  /**
   * RR Doporučená zásilka do zahraničí Prioritní
   */
  CP_RZP("RZP"),

  /**
   * VL Cenné psaní do zahraničí Prioritní
   */
  CP_VZP("VZP"),

  /**
   * EMS Expresní přeprava do zahraničí
   */
  CP_EM("EM"),

  /**
   * CS Standardní balík do zahraničí Prioritní
   */
  CP_CSP("CSP"),

  /**
   * CS Standardní balík do zahraničí Ekonomický
   */
  CP_CSE("CSE"),

  /**
   * CV Cenný balík do zahraničí Prioritní
   */
  CP_CVP("CVP"),

  /**
   * CV Cenný balík do zahraničí Ekonomický
   */
  CP_CVE("CVE"),

  /**
   * Obchodní balík do zahraničí
   */
  CP_CE("CE"),

  /**
   * Obyčejná listovní zásilka mezinárodní
   */
  CP_OLZ("OLZ"),

  /**
   * PPL Parcel Business CZ
   */
  PPL_PARCEL_BUSSINESS_CZ("1"),

  /**
   * PPL Parcel Connect (exportní balík)
   */
  PPL_CONNECT("2"),

  /**
   * PPL Parcel CZ Dopolední balík
   */
  PPL_AFTERNOON("3"),

  /**
   * PPL Parcel CZ Private (soukromý balík)
   */
  PPL_PRIVATE("4"),

  /**
   * PPL Parcel CZ Business (firemní balík)
   */
  PPL_BUSINESS("8"),

  /**
   * PPL Parcel CZ Private - Večerní doručení
   */
  PPL_PRIVATE_EVENING("9"),

  /**
   * PPL Parcel Business Europe
   */
  PPL_BUSINESS_EU("10"),

  /**
   * PPl Parcel Import
   */
  PPL_PARCEL_IMPORT("11"),

  /**
   * PPL Firemní paleta
   */
  PPL_BUSINESS_PALETTE("15"),

  /**
   * PPL Soukromá paleta
   */
  PPL_PRIVATE_PALETTE("19"),

  /**
   * PPL Smart CZ
   */
  PPL_PRIVATE_SMART_CZ("46"),

  /**
   * PPL Smart Europe
   */
  PPL_PRIVATE_SMART_EU("48"),

  /**
   * DPD Classic
   */
  DPD_CLASSIC("1"),

  /**
   * DPD Private
   */
  DPD_PRIVATE("2"),

  /**
   * DPD Pickup
   */
  DPD_PICKUP("3"),

  /**
   * DPD Expresní doručení do 10:00
   */
  DPD_EXPRESS_10("4"),

  /**
   * DPD Expresní doručení do 12:00
   */
  DPD_EXPRESS_12("5"),

  /**
   * DPD Expresní doručení do 18:00
   */
  DPD_EXPRESS_18("6"),

  /**
   * DPD Private večerní doručení
   */
  DPD_PRIVATE_EVENING("7"),

  /**
   * DPD Private sobotní doručení
   */
  DPD_PRIVATE_SATURDAY("8"),

  /**
   * Vnitrostátní paletová zásilka B2B
   */
  GEIS_CARGO_BUSINESS_NATIONAL("4"),

  /**
   * Mezinárodní paletová zásilka B2B
   */
  GEIS_CARGO_BUSINESS_INTERNATIONAL("5"),

  /**
   * Vnitrostátní paletová zásilka B2C
   */
  GEIS_CARGO_PRIVATE_NATIONAL("10"),

  /**
   * Mezinárodní paletová zásilka B2C
   */
  GEIS_CARGO_PRIVATE_INTERNATIONAL("11"),

  /**
   * Home Delivery Standard
   */
  GEIS_PARCEL_HD_STANDARD("12"),

  /**
   * Home Delivery Premium
   */
  GEIS_PARCEL_HD_PREMIUM("13"),

  /**
   * Business Parcel (doručení do ruky)
   */
  GLS_BUSINESS("1"),

  /**
   * ShopDelivery Service (doručení na výdejní místo)
   */
  GLS_SHOP("2"),

  /**
   * Express Parcel (expresní zásilka)
   */
  GLS_EXPRESS("3"),

  /**
   * Guaranteed 24 Service Business Parcel
   */
  GLS_GUARANTEED24("4"),

  /**
   * "Guaranteed 24 Service Express Parcel
   */
  GLS_GUARANTEED24_EXPRESS("5"),

  /**
   * Guaranteed 24 Service ShopDelivery
   */
  GLS_GUARANTEED24_SHOP("6"),

  /**
   * Small Colli 24-CZ
   */
  INTIME_SMALL_CZ("1"),

  /**
   * Medium Colli 24-CZ
   */
  INTIME_MEDIUM_CZ("2"),

  /**
   * Large Colli 24-CZ
   */
  INTIME_LARGE_CZ("3"),

  /**
   * Poštomat CZ
   */
  INTIME_POSTOMAT_CZ("4"),

  /**
   * Poštomat SK
   */
  INTIME_POSTOMAT_SK("5"),

  /**
   * Large Colli 48-SK
   */
  INTIME_LARGE_SK("6"),

  /**
   * Extra Large Colli 24-CZ
   */
  INTIME_EXTRA_CZ("7"),

  /**
   * Parcel EU
   */
  INTIME_PARCEL_EU("8"),

  /**
   * Parcel EU+
   */
  INTIME_PARCEL_EU_PLUS("9"),

  /**
   * BOXCZ - Výdejní box CZ
   */
  INTIME_BOX_CZ("10"),

  /**
   * BOXSK - Výdejní box SK
   */
  INTIME_BOX_SK("11"),

  /**
   * 24 hodin (Standard)
   */
  TOPTRANS_STANDARD("1"),

  /**
   * Toptime
   */
  TOPTRANS_TOPTIME("2"),

  /**
   * Privat
   */
  TOPTRANS_PRIVATE("3"),

  /**
   * Weekend
   */
  TOPTRANS_WEEKEND("4"),

  /**
   * Osobní odběr
   */
  TOPTRANS_PERSONAL("5"),

  /**
   * Po avizaci
   */
  TOPTRANS_NOTICE("6"),

  /**
   * Balík na adresu – zmluvní zákazníci
   */
  SP_BZA("BZA"),

  /**
   * Balík na poštu – zmluvní zákazníci
   */
  SP_BZP("BZP"),

  /**
   * Balík do BalíkoBOXu
   */
  SP_BZB("BZB"),

  /**
   * Expres kuriér na adresu
   */
  SP_EXA("EXA"),

  /**
   * Expres kuriér na poštu
   */
  SP_EXP("EXP"),

  /**
   * Expres kuriér do BalíkoBOXu
   */
  SP_EXB("EXB"),

  /**
   * Balík na adresu
   */
  SP_BNA("BNA"),

  /**
   * Balík na poštu
   */
  SP_BNP("BNP"),

  /**
   * Balík do BalíkoBOXu
   */
  SP_BNB("BNB"),

  /**
   * Doporučený list
   */
  SP_RRA("RRA"),

  /**
   * Expres (vnitrostátní zásilky)
   */
  SPS_EXPRESS("1"),

  /**
   * Expres do 12:00 (vnitrostátní zásilky)
   */
  SPS_EXPRESS_12("2"),

  /**
   * Expres do 09:00 (vnitrostátní zásilky)
   */
  SPS_EXPRESS_9("3"),

  /**
   * Export (mezinárodní zásilky)
   */
  SPS_INTERNATIONAL("4"),

  /**
   * Uloženka
   */
  ULOZENKA_ULOZENKA("1"),

  /**
   * Slovenská pošta
   */
  ULOZENKA_SP("2"),

  /**
   * DPD Classic na Slovensko
   */
  ULOZENKA_DPD_CLASSIC_SK("3"),

  /**
   * DPD Private pro ČR a SK
   */
  ULOZENKA_DPD_PRIVATE("4"),

  /**
   * DPD ParcelShop
   */
  ULOZENKA_DPD_PARCEL("5"),

  /**
   * Balík do ruky – Česká pošta,
   */
  ULOZENKA_CP_DR("6"),

  /**
   * Balík na poštu – Česká pošta
   */
  ULOZENKA_CP_NP("7"),

  /**
   * Partner
   */
  ULOZENKA_PARTNER("11"),

  /**
   * Doručení na adresu D+1
   */
  ULOZENKA_D1("17"),

  /**
   * Expres Kurýr SK
   */
  ULOZENKA_EXPRESS_COURRIER("19"),

  /**
   * Expres na poštu SK
   */
  ULOZENKA_EXPRESS_SK("20"),

  /**
   * BalíkoBOX SK
   */
  ULOZENKA_BALIKOBOX_SK("21"),

  /**
   * Depo SK
   */
  ULOZENKA_DEPO_SK("22"),

  /**
   * Mall Delivery
   */
  ULOZENKA_MALL_DELIVERY("100"),

  /**
   * Výdejní místa Česká republika
   */
  ZASILKOVNA_VMCZ("VMCZ"),

  /**
   * Výdejní místa Slovenská republika
   */
  ZASILKOVNA_VMSK("VMSK"),

  /**
   * Výdejní místa Maďarsko
   */
  ZASILKOVNA_VMHU("VMHU"),

  /**
   * Výdejní místa Polsko
   */
  ZASILKOVNA_VMPL("VMPL"),

  /**
   * Výdejní místa Rumunsko
   */
  ZASILKOVNA_VMRO("VMRO"),

  /**
   * AT Rakouská pošta HD
   */
  ZASILKOVNA_AT_POST_HD("80"),

  /**
   * AT DPD HD
   */
  ZASILKOVNA_AT_DPD_HD("6830"),

  /**
   * BE Belgická pošta PP
   */
  ZASILKOVNA_BE_POST_PP("7910"),

  /**
   * BE Belgická pošta HD
   */
  ZASILKOVNA_BE_POST_HD("7909"),

  /**
   * BE Nizozemská pošta HD
   */
  ZASILKOVNA_BE_NL_POST_HD("4832"),

  /**
   * BG Econt HD
   */
  ZASILKOVNA_BG_ECONT_HD("6006"),

  /**
   * BG Econt PP
   */
  ZASILKOVNA_BG_ECONT_PP("7377"),

  /**
   * BG Speedy PP
   */
  ZASILKOVNA_BG_SPEEDY_PP("4017"),

  /**
   * BG Speedy HD
   */
  ZASILKOVNA_BG_SPEEDY_HD("4015"),

  /**
   * BG Econt Box
   */
  ZASILKOVNA_BG_ECONT_BOX("7378"),

  /**
   * CZ Česká pošta HD
   */
  ZASILKOVNA_CZ_POST_HD("13"),

  /**
   * CZ - Nejvýhodnější doručení na adresu
   */
  ZASILKOVNA_CZ_COURIER_HD("106"),

  /**
   * Expresní doručení Praha
   */
  ZASILKOVNA_CZ_EXPRESS_PRAHA_HD("257"),

  /**
   * Expresní doručení Brno
   */
  ZASILKOVNA_CZ_EXPRESS_BRNO_HD("136"),

  /**
   * Expresní doručení Ostrava
   */
  ZASILKOVNA_CZ_EXPRESS_OSTRAVA_HD("134"),

  /**
   * DE Německá pošta DHL HD
   */
  ZASILKOVNA_DE_POST_HD("111"),

  /**
   * Německo Hermes PP
   */
  ZASILKOVNA_DE_HERMES_PP("6828"),

  /**
   * DE Hermes Home
   */
  ZASILKOVNA_DE_HERMES_HD("6373"),

  /**
   * DE Home Delivery HD
   */
  ZASILKOVNA_DE_HOME_DELIVERY_HD("13613"),

  /**
   * DK Post Nord Home
   */
  ZASILKOVNA_DK_POST_NORD_HD("4993"),

  /**
   * DK Post Nord PP
   */
  ZASILKOVNA_DK_POST_NORD_PP("4994"),

  /**
   * DK DAO HD
   */
  ZASILKOVNA_DK_DAO_HD("9725"),

  /**
   * DK DAO PP
   */
  ZASILKOVNA_DK_DAO_PP("9726"),

  /**
   * EE Omniva Home
   */
  ZASILKOVNA_EE_OMNIVA_HD("5060"),

  /**
   * EE Omniva pickup
   */
  ZASILKOVNA_EE_OMNIVA_PP("5061"),

  /**
   * EE Omniva Box
   */
  ZASILKOVNA_EE_OMNIVA_BOX("5062"),

  /**
   * ES Correos HD
   */
  ZASILKOVNA_ES_CORREOS_HD("4638"),

  /**
   * ES MRW Home
   */
  ZASILKOVNA_ES_MRW_HD("4653"),

  /**
   * ES MRW Pickup Point
   */
  ZASILKOVNA_ES_MRW_PP("4654"),

  /**
   * FI Post Nord Home
   */
  ZASILKOVNA_FI_POST_NORD_HP("4830"),

  /**
   * FI Post Nord Pickup Point
   */
  ZASILKOVNA_FI_POST_NORD_PP("4828"),

  /**
   * FR Colis Privé HD
   */
  ZASILKOVNA_FR_COLIS_PRIVE_HD("4033"),

  /**
   * FR Mondial PP
   */
  ZASILKOVNA_FR_MONDIAL_PP("4876"),

  /**
   * Francie Colissimo PP
   */
  ZASILKOVNA_FR_COLISSIMO_PP("4307"),

  /**
   * Francie Colissimo Home
   */
  ZASILKOVNA_FR_COLISSIMO_HD("4309"),

  /**
   * Spojené království Hermes
   */
  ZASILKOVNA_GB_HERMES_HD("3885"),

  /**
   * Spojené království Royal Mail 24
   */
  ZASILKOVNA_GB_ROYAL_MAIL_24_HD("4856"),

  /**
   * Spojené království Royal Mail 48
   */
  ZASILKOVNA_GB_ROYAL_MAIL_48_HD("4857"),

  /**
   * GR Taxydromiki
   */
  ZASILKOVNA_GR_TAXYDROMIKI("8847"),

  /**
   * GR ACS HD
   */
  ZASILKOVNA_GR_ACS_HD("7770"),

  /**
   * GR ACS PP
   */
  ZASILKOVNA_GR_ACS_PP("7788"),

  /**
   * Recko Speedy Home
   */
  ZASILKOVNA_GR_SPEEDY_HD("4738"),

  /**
   * HR Overseas Express HD
   */
  ZASILKOVNA_HR_OVERSEAS_HD("10618"),

  /**
   * HR Overseas PP
   */
  ZASILKOVNA_HR_OVERSEAS_PP("10619"),

  /**
   * Chorvatsko DPD Home
   */
  ZASILKOVNA_HR_DPD_HD("4646"),

  /**
   * Chorvatská Pošta - Výdejní místo
   */
  ZASILKOVNA_HR_POST_PP("4635"),

  /**
   * Chorvatská Pošta - doručení na adresu
   */
  ZASILKOVNA_HR_POST_HD("4634"),

  /**
   * Maďarsko Express One (Transoflex)
   */
  ZASILKOVNA_HU_EXPRESS_ONE_HD("151"),

  /**
   * Maďarsko DPD
   */
  ZASILKOVNA_HU_DPD_HD("805"),

  /**
   * HU - best delivery solution
   */
  ZASILKOVNA_HU_COURIER_HD("4159"),

  /**
   * Maďarská pošta
   */
  ZASILKOVNA_HU_POST_HD("763"),

  /**
   * Švýcarsko-Lichtenštejnská Pošta - prioritní
   */
  ZASILKOVNA_CH_POST_PRIORITY_HD("3870"),

  /**
   * Švýcarsko-Lichtejnštejnská Pošta
   */
  ZASILKOVNA_CH_POST_HD("3294"),

  /**
   * Irsko Hermes
   */
  ZASILKOVNA_IE_HERMES_HD("4524"),

  /**
   * IE Anpost HD
   */
  ZASILKOVNA_IE_ANPOST_HD("9990"),

  /**
   * IT Bartolini Home
   */
  ZASILKOVNA_IT_BARTOLINI_HD("9103"),

  /**
   * IT Bartolini PP
   */
  ZASILKOVNA_IT_BARTOLINI_PP("9104"),

  /**
   * Itálie GLS
   */
  ZASILKOVNA_IT_GLS_HD("2726"),

  /**
   * LT Omniva Box
   */
  ZASILKOVNA_LT_OMNIVA_BOX("5066"),

  /**
   * LT Omniva Home
   */
  ZASILKOVNA_LT_OMNIVA_HD("5065"),

  /**
   * LU Lucemburská pošta HD
   */
  ZASILKOVNA_LU_POST_HD("8125"),

  /**
   * LU DPD
   */
  ZASILKOVNA_LU_DPD_HD("4834"),

  /**
   * LV Omniva Box
   */
  ZASILKOVNA_LV_OMNIVA_BOX("5064"),

  /**
   * LV Omniva Home
   */
  ZASILKOVNA_LV_OMNIVA_HD("5063"),

  /**
   * NL DHL HD
   */
  ZASILKOVNA_NL_DHL_HD("8000"),

  /**
   * NL Post
   */
  ZASILKOVNA_NL_POST_HD("4329"),

  /**
   * NL DHL PP
   */
  ZASILKOVNA_NL_DHL_PP("8001"),

  /**
   * Polská pošta 24h
   */
  ZASILKOVNA_PL_POST_24_HD("1438"),

  /**
   * Polská pošta
   */
  ZASILKOVNA_PL_POST_48_HD("272"),

  /**
   * Polsko DPD
   */
  ZASILKOVNA_PL_DPD_HD("1406"),

  /**
   * PL - best delivery solution
   */
  ZASILKOVNA_PL_COURIER_HD("4162"),

  /**
   * Polsko Paczkomaty
   */
  ZASILKOVNA_PL_INPOST_PACZKOMATY_BOX("3060"),

  /**
   * Polsko InPost
   */
  ZASILKOVNA_PL_INPOST_HD("3603"),

  /**
   * PT MRW Home
   */
  ZASILKOVNA_PT_MRW_HD("4655"),

  /**
   * PT MRW PP
   */
  ZASILKOVNA_PT_MRW_PP("4656"),

  /**
   * RO - best delivery solution
   */
  ZASILKOVNA_RO_COURIER_HD("4161"),

  /**
   * Rumunsko Cargus
   */
  ZASILKOVNA_RO_URGENT_CARGUS_HD("590"),

  /**
   * Rumunsko Sameday box
   */
  ZASILKOVNA_RO_SAMEDAY_BOX("7455"),

  /**
   * Rumunsko DPD
   */
  ZASILKOVNA_RO_DPD_HD("836"),

  /**
   * Rumunsko Sameday HD
   */
  ZASILKOVNA_RO_SAMEDAY_HD("7397"),

  /**
   * Rumunsko FAN
   */
  ZASILKOVNA_RO_FAN_COURIER_HD("762"),

  /**
   * Ruská pošta
   */
  ZASILKOVNA_RU_POST_PP("4559"),

  /**
   * RU Post Registered Packet
   */
  ZASILKOVNA_RU_POST_RECOMMENDED_PP("5102"),

  /**
   * RU Post EMS
   */
  ZASILKOVNA_RU_EMS_HD("5101"),

  /**
   * SE Post Nord pp
   */
  ZASILKOVNA_SE_POST_NORD_PP("4826"),

  /**
   * SE Post Nord Home
   */
  ZASILKOVNA_SE_POST_NORD_HD("4827"),

  /**
   * SI DPD Home
   */
  ZASILKOVNA_SI_DPD_HD("4949"),

  /**
   * SI DPD Pickup
   */
  ZASILKOVNA_SI_DPD_PP("4950"),

  /**
   * SI Post HD
   */
  ZASILKOVNA_SI_POST_HD("10741"),

  /**
   * SI Post PP
   */
  ZASILKOVNA_SI_POST_PP("10742"),

  /**
   * SI Post Box
   */
  ZASILKOVNA_SI_POST_BOX("11122"),

  /**
   * Expresné doručenie Bratislava
   */
  ZASILKOVNA_SK_EXPRESS_BRATISLAVA_HD("132"),

  /**
   * SK - Best delivery solution
   */
  ZASILKOVNA_SK_COURIER_HD("131"),

  /**
   * Slovenská pošta
   */
  ZASILKOVNA_SK_POST_HD("16"),

  /**
   * Ukrajina Nova Poshta
   */
  ZASILKOVNA_UA_NOVA_POSHTA_PP("3616"),

  /**
   * Ukrajina Rosan
   */
  ZASILKOVNA_UA_ROSAN_HD("1160"),

  /**
   * US FedEx HD Economy
   */
  ZASILKOVNA_US_FEDEX_ECONOMY_HD("8289"),

  /**
   * US Fedex HD Priority
   */
  ZASILKOVNA_US_FEDEX_PRIORITY_HD("8701"),

  /**
   * DHL
   */
  PBH_DHL("1"),

  /**
   * GLS
   */
  PBH_GLS("2"),

  /**
   * UPS
   */
  PBH_UPS("3"),

  /**
   * Slovenská pošta
   */
  PBH_SP("4"),

  /**
   * Transoflex
   */
  PBH_TRANSOFLEX("5"),

  /**
   * Maďarská pošta
   */
  PBH_MP("6"),

  /**
   * Cargus
   */
  PBH_CARGUS("7"),

  /**
   * Rakouská pošta
   */
  PBH_RP("8"),

  /**
   * Česká pošta – Balík do ruky
   */
  PBH_CP_DR("9"),

  /**
   * Česká pošta – Balík na poštu
   */
  PBH_CP_NP("10"),

  /**
   * PPL
   */
  PBH_PPL("11"),

  /**
   * DPD
   */
  PBH_DPD("12"),

  /**
   * Polská pošta
   */
  PBH_PP("13"),

  /**
   * polský Inpost Kurier
   */
  PBH_INPOST_KURIER("14"),

  /**
   * FAN Courier
   */
  PBH_FAN_KURIER("15"),

  /**
   * Hermes
   */
  PBH_HERMES("16"),

  /**
   * Speedy
   */
  PBH_SPEEDY("17"),

  /**
   * Colissimo
   */
  PBH_COLISSIMO("18"),

  /**
   * Meest
   */
  PBH_MEEST("19"),

  /**
   * Nova Poshta
   */
  PBH_NOBA_POSHTA("20"),

  /**
   * Econt
   */
  PBH_ECONT("21"),

  /**
   * ACS
   */
  PBH_ACS("22"),

  /**
   * Correos
   */
  PBH_CORREOS("23"),

  /**
   * 123 Kuriér
   */
  PBH_123_KURIER("24"),

  /**
   * RoyalMail 24h
   */
  PBH_ROYAL_MAIL_24("25"),
  /**
   * RoyalMail 48h
   */
  PBH_ROYAL_MAIL_48("26"),

  /**
   * Worlwide zásilky
   */
  DHL_WORLDWIDE("1"),

  /**
   * Express Worldwide dokumenty
   */
  DHL_EXPRESS_DOCUMENTS("2"),

  /**
   * Express Worldwide 9:00
   */
  DHL_EXPRESS_WORLDWIDE_9("3"),

  /**
   * Express Worldwide 12:00
   */
  DHL_EXPRESS_WORLDWIDE_12("4"),

  /**
   * Economy Select
   */
  DHL_ECONOMY("5"),

  /**
   * Domestic Express 12:00
   */
  DHL_DOMESTIC_12("6"),

  /**
   * Domestic Express
   */
  DHL_DOMESTIC_EXPRESS("7"),

  /**
   * Express
   */
  UPS_EXPRESS("1"),

  /**
   * Express Saver
   */
  UPS_EXPRESS_SAVER("2"),

  /**
   * Standard
   */
  UPS_STANDARD("3"),

  /**
   * Expedited
   */
  UPS_EXPEDITED("4"),

  /**
   * Express
   */
  TNT_EXPRESS("1"),

  /**
   * Express 9:00
   */
  TNT_EXPRESS_9("2"),

  /**
   * Express 12:00
   */
  TNT_EXPRESS_12("3"),

  /**
   * Economy Express
   */
  TNT_ECONOMY_EXPRESS("4"),

  /**
   * Night Express 8:00
   */
  TNT_NIGHT_EXPRESS_8("5"),

  /**
   * Economy Express 12:00
   */
  TNT_ECONOMY_EXPRESS_12("6"),

  /**
   * Express 10:00
   */
  TNT_EXPRESS_10("7"),

  /**
   * Express (Documents)
   */
  TNT_EXPRESS_DOCUMENTS("8"),

  /**
   * Express 9:00 (Documents)
   */
  TNT_EXPRESS_DOCUMENTS_9("9"),

  /**
   * Express 10:00 (Documents)
   */
  TNT_EXPRESS_DOCUMENTS_10("10"),

  /**
   * Express 12:00 (Documents)
   */
  TNT_EXPRESS_DOCUMENTS_12("11"),

  /**
   * Night Express 12:00
   */
  TNT_NIGHT_EXPRESS_12("12"),

  /**
   * Night Express 06:00
   */
  TNT_NIGHT_EXPRESS_6("13"),

  /**
   * Night Express 07:00
   */
  TNT_NIGHT_EXPRESS_7("14"),

  /**
   * Night Express 14:00
   */
  TNT_NIGHT_EXPRESS_14("15"),

  /**
   * Special economy express
   */
  TNT_SPECIAL_ECONOMY_EXPRESS("16"),

  /**
   * Direct Infeed
   */
  TNT_DIRECT_INFEED("17"),

  /**
   * Priority Goods 9:00
   */
  GW_PRIORITY_9("P9"),

  /**
   * Priority Goods 12:00
   */
  GW_PRIORITY_12("P12"),

  /**
   * Priority Goods 16:00
   */
  GW_PRIORITY_16("P16"),

  /**
   * Direct Goods
   */
  GW_DIRECT_GOODS("WDG"),

  /**
   * Pick Up
   */
  GW_PICKUP("BES"),

  /**
   * Pickup by Consignee
   */
  GW_PICKUP_BY_CONSIGNEE("SA"),

  /**
   * Domestic PRON
   */
  GW_DOMESTIC("W24"),

  /**
   * HDS - Home Delivery Services
   */
  GW_HOME_DELIVERY("HDS"),

  /**
   * Export PROI
   */
  GW_EXPORT("EUR"),

  /**
   * Domestic PRON
   */
  GW_W24("W24"),

  /**
   * Domestic 8:00 - 12:00
   */
  GW_D8("D8"),

  /**
   * Domestic 12:00 - 14:00
   */
  GW_D12("D12"),

  /**
   * Domestic 14:00 - 18:00
   */
  GW_D14("D14"),

  /**
   * Export PROI
   */
  GW_EUR("EUR"),

  /**
   * Standard
   */
  MESSENGER_STANDARD("100"),

  /**
   * Extreme
   */
  MESSENGER_EXTREME("102"),

  /**
   * Express
   */
  MESSENGER_EXPRESS("103"),

  /**
   * Same day
   */
  MESSENGER_SAME_DAY("104"),

  /**
   * Overnight Economy
   */
  MESSENGER_OVERNIGHT_ECONOMY("106"),

  /**
   * Overnight Express
   */
  MESSENGER_OVERNIGHT_EXPRESS("107"),

  /**
   * Direct
   */
  MESSENGER_DIRECT("108"),

  /**
   * Praha – 9-13h
   */
  MESSENGER_PRAGUE_09_13("205"),

  /**
   * Praha – 13-17h
   */
  MESSENGER_PRAGUE_13_17("206"),

  /**
   * Praha – 17-21h
   */
  MESSENGER_PRAGUE_17_21("207"),

  /**
   * DHL Paket
   */
  DHLDE_PAKET("1"),

  /**
   * DHL Paket Taggleich
   */
  DHLDE_PAKET_TAGGLEICH("2"),

  /**
   * DHL Paket International
   */
  DHLDE_PAKET_INTERNATIONAL("3"),

  /**
   * DHL Europaket
   */
  DHLDE_EUROPAKET("4"),

  /**
   * DHL Paket Connect
   */
  DHLDE_PAKET_CONNECT("5"),

  /**
   * FedEx International Priority
   */
  FEDEX_INTERNATIONAL("1"),

  /**
   * FedEx International Economy
   */
  FEDEX_ECONOMY("2"),

  /**
   * Fofr
   */
  FOFR_FOFR("F"),

  /**
   * Fofr Economy
   */
  FOFR_ECONOMY("C"),

  /**
   * Fofr Balíková přeprava
   */
  FOFR_PARCEL("B"),

  /**
   * Fofr Paletová přeprava
   */
  FOFR_PALETTE("P"),

  /**
   * Fofr Nadrozměrná zásilka
   */
  FOFR_OVERSIZED("N"),

  /**
   * Fofr Slovensko
   */
  FOFR_SK("S"),

  /**
   * Fofr Zahraničí
   */
  FOFR_ABROAD("Z"),

  /**
   * Dachser Targospeed
   */
  DACHSER_SPEED("Z"),

  /**
   * Dachser Targospeed 10
   */
  DACHSER_SPEED_10("S"),

  /**
   * Dachser Targospeed 12
   */
  DACHSER_SPEED_12("E"),

  /**
   * Dachser Targospeed plux
   */
  DACHSER_SPEED_PLUS("X"),

  /**
   * Dachser Targofix
   */
  DACHSER_FIX("V"),

  /**
   * Dachser Targofix 10
   */
  DACHSER_FIX_10("R"),

  /**
   * Dachser Targofix 12
   */
  DACHSER_FIX_12("W"),

  /**
   * Dachser Targoflex
   */
  DACHSER_FLEX("Y"),

  /**
   * Dachser Targo on-site
   */
  DACHSER_ONSITE("A"),

  /**
   * Dachser classicline
   */
  DACHSER_CLASSIC("N"),

  /**
   * DHL Parcel Connect
   */
  DHLPARCEL_CONNECT("1"),

  /**
   * Raben Cargo Classic
   */
  RABEN_CLASSIC("PROD01"),

  /**
   * Raben Cargo Classic - Time slot
   */
  RABEN_CLASSIC_TIME("PROD01-RTS"),

  /**
   * Raben Cargo Premium
   */
  RABEN_PREMIUM("PROD02"),

  /**
   * Raben Cargo Premium - Time slot
   */
  RABEN_PREMIUM_TIME("PROD02-RTS"),

  /**
   * Raben Cargo Premium - Delivery till 12:00 p
   */
  RABEN_PREMIUM_12("PROD02-ND12"),

  /**
   * Raben Cargo Premium - Fixed date
   */
  RABEN_PREMIUM_FIX("PROD02-FIX"),

  /**
   * Spring Tracked
   */
  SPRING_TRACKED("TRCK"),

  /**
   * Spring Signatured
   */
  SPRING_SIGNATURED("SIGN"),

  /**
   * Spring Untracked
   */
  SPRING_UNTRACKED("UNTR"),

  /**
   * DSV Road
   */
  DSV_ROAD("road"),

  /**
   * DSV B2C
   */
  DSV_B2C("b2c"),

  /**
   * DHLFREIGHTEC EuroConnect Domestic B2B
   */
  DHLFREIGHTEC_ECD_B2B("ECD_B2B"),

  /**
   * DHLFREIGHTEC EuroConnect Domestic B2C
   */
  DHLFREIGHTEC_ECD_B2C("ECD_B2C"),

  /**
   * DHLFREIGHTEC EuroConnect International
   */
  DHLFREIGHTEC_ECI("ECI"),

  /**
   * DHLFREIGHTEC EuroRapid International
   */
  DHLFREIGHTEC_ERI("ERI"),

  /**
   * KURIER Garantované doručení
   */
  KURIER_GARANTED("gdd"),

  /**
   * KURIER Doručení do 12h
   */
  KURIER_12("d12"),

  /**
   * KURIER Statndard
   */
  KURIER_STANDARD("std"),

  /**
   * DB Schenker System FIX
   */
  DBSCHENKER_SYSTEM_FIX("35"),

  /**
   * DB Schenker System FIX TBA
   */
  DBSCHENKER_SYSTEM_FIX_TBA("39"),

  /**
   * DB Schenker System
   */
  DBSCHENKER_SYSTEM("43"),

  /**
   * DB Schenker System Premium
   */
  DBSCHENKER_SYSTEM_PREMIUM("44"),

  /**
   * DB Schenker System Premium 10
   */
  DBSCHENKER_SYSTEM_PREMIUM_10("55"),

  /**
   * DB Schenker System Premium 13
   */
  DBSCHENKER_SYSTEM_PREMIUM_13("56"),

  /**
   * DB Schenker System FIX 10
   */
  DBSCHENKER_SYSTEM_FIX_10("57"),

  /**
   * DB Schenker System FIX 13
   */
  DBSCHENKER_SYSTEM_FIX_13("58"),

  /**
   * DB Schenker Full Load
   */
  DBSCHENKER_FULL_LOAD("71"),

  /**
   * DB Schenker Part Load
   */
  DBSCHENKER_PART_LOAD("72"),

  /**
   * Airway Express
   */
  AIRWAY_EXPRESS("1"),

  /**
   * Airway Normal
   */
  AIRWAY_NORMAL("2"),

  /**
   * Airway Economy
   */
  AIRWAY_ECONOMY("3"),

  /**
   * Airway Same Day
   */
  AIRWAY_SAME_DAY("4"),

  /**
   * Airway Prague 9-13
   */
  AIRWAY_PRAGUE_13("5"),

  /**
   * Airway Prague 13-17
   */
  AIRWAY_PRAGUE_17("6"),

  /**
   * Airway Prague 17-21
   */
  AIRWAY_PRAGUE_21("7"),

  /**
   * Airway Další den
   */
  AIRWAY_NEXT_DAY("8"),

  /**
   * Airway Další pracovní den
   */
  AIRWAY_NEXT_WEEKDAY("9");

  public final String label;

  ServiceType(String label) {
    this.label = label;
  }

  public static ServiceType valueOfLabel(String label) {
    for (ServiceType e : values()) {
      if (e.label.equals(label)) {
        return e;
      }
    }
    return null;
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> cp() {
    return Arrays.asList(
        CP_DR,
        CP_RR,
        CP_SR,
        CP_RRP,
        CP_SRP,
        CP_NP,
        CP_VL,
        CP_DV,
        CP_BA,
        CP_BB,
        CP_BN,
        CP_NB,
        CP_DT,
        CP_DS,
        CP_EE,
        // CP_BE,
        CP_RZP,
        CP_VZP,
        CP_EM,
        CP_CSP,
        CP_CSE,
        CP_CVP,
        CP_CVE,
        CP_CE,
        CP_OLZ
    );
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dpd() {
    return Arrays.asList(
        DPD_CLASSIC,
        DPD_PRIVATE,
        DPD_PICKUP,
        DPD_EXPRESS_10,
        DPD_EXPRESS_12,
        DPD_EXPRESS_18,
        // DPD_PRIVATE_EVENING,
        DPD_PRIVATE_SATURDAY);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dhl() {
    return Arrays.asList(
        DHL_WORLDWIDE,
        DHL_EXPRESS_DOCUMENTS,
        DHL_EXPRESS_WORLDWIDE_9,
        DHL_EXPRESS_WORLDWIDE_12,
        DHL_ECONOMY,
        DHL_DOMESTIC_12,
        DHL_DOMESTIC_EXPRESS);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> geis() {
    return Arrays.asList(
        GEIS_CARGO_BUSINESS_NATIONAL,
        GEIS_CARGO_BUSINESS_INTERNATIONAL,
        GEIS_CARGO_PRIVATE_NATIONAL,
        GEIS_CARGO_PRIVATE_INTERNATIONAL,
        GEIS_PARCEL_HD_STANDARD,
        GEIS_PARCEL_HD_PREMIUM);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> gls() {
    return Arrays.asList(
        GLS_BUSINESS,
        GLS_SHOP,
        GLS_EXPRESS,
        GLS_GUARANTEED24,
        GLS_GUARANTEED24_EXPRESS,
        GLS_GUARANTEED24_SHOP);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> intime() {
    return Arrays.asList(
        INTIME_SMALL_CZ,
        INTIME_MEDIUM_CZ,
        INTIME_LARGE_CZ,
        INTIME_POSTOMAT_CZ,
        // INTIME_POSTOMAT_SK,
        INTIME_LARGE_SK,
        INTIME_EXTRA_CZ,
        INTIME_PARCEL_EU,
        INTIME_PARCEL_EU_PLUS,
        INTIME_BOX_CZ,
        INTIME_BOX_SK);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> pbh() {
    return Arrays.asList(
        PBH_DHL,
        PBH_GLS,
        PBH_UPS,
        PBH_SP,
        PBH_TRANSOFLEX,
        PBH_MP,
        PBH_CARGUS,
        PBH_RP,
        PBH_CP_DR,
        PBH_CP_NP,
        PBH_PPL,
        PBH_DPD,
        PBH_PP,
        PBH_INPOST_KURIER,
        PBH_FAN_KURIER,
        // PBH_HERMES,
        PBH_SPEEDY,
        PBH_COLISSIMO,
        PBH_MEEST,
        PBH_NOBA_POSHTA,
        PBH_ECONT,
        PBH_ACS,
        PBH_CORREOS,
        PBH_123_KURIER,
        PBH_ROYAL_MAIL_24,
        PBH_ROYAL_MAIL_48);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> ppl() {
    return Arrays.asList(
        PPL_CONNECT,
        PPL_AFTERNOON,
        PPL_PRIVATE,
        PPL_BUSINESS,
        PPL_PRIVATE_EVENING,
        PPL_BUSINESS_EU,
        PPL_BUSINESS_PALETTE,
        PPL_PRIVATE_PALETTE,
        PPL_PRIVATE_SMART_CZ,
        PPL_PRIVATE_SMART_EU);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> sp() {
    return Arrays.asList(
        SP_BZA,
        SP_BZP,
        SP_BZB,
        SP_EXA,
        SP_EXP,
        SP_EXB,
        SP_BNA,
        SP_BNP,
        SP_BNB,
        SP_RRA);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> sps() {
    return Arrays.asList(
        SPS_EXPRESS,
        SPS_EXPRESS_12,
        SPS_EXPRESS_9,
        SPS_INTERNATIONAL);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> topTrans() {
    return Arrays.asList(
        TOPTRANS_STANDARD,
        TOPTRANS_TOPTIME,
        TOPTRANS_PRIVATE,
        TOPTRANS_WEEKEND,
        TOPTRANS_PERSONAL,
        TOPTRANS_NOTICE);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> ulozenka() {
    return Arrays.asList(
        ULOZENKA_ULOZENKA,
        ULOZENKA_SP,
        ULOZENKA_DPD_CLASSIC_SK,
        ULOZENKA_DPD_PRIVATE,
        ULOZENKA_DPD_PARCEL,
        ULOZENKA_CP_DR,
        ULOZENKA_CP_NP,
        ULOZENKA_PARTNER,
        ULOZENKA_D1,
        ULOZENKA_EXPRESS_COURRIER,
        ULOZENKA_EXPRESS_SK,
        ULOZENKA_BALIKOBOX_SK,
        ULOZENKA_DEPO_SK,
        ULOZENKA_MALL_DELIVERY);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> ups() {
    return Arrays.asList(
        UPS_EXPRESS,
        UPS_EXPRESS_SAVER,
        UPS_STANDARD,
        UPS_EXPEDITED);
  }

  /**
   * @return ArrayList<mixed>
   */
  public static List<ServiceType> zasilkovna() {
    return Arrays.asList(
        ZASILKOVNA_VMCZ,
        ZASILKOVNA_VMSK,
        ZASILKOVNA_VMHU,
        ZASILKOVNA_VMPL,
        ZASILKOVNA_VMRO,
        ZASILKOVNA_AT_DPD_HD,
        ZASILKOVNA_AT_POST_HD,
        ZASILKOVNA_BE_POST_PP,
        ZASILKOVNA_BE_POST_HD,
        ZASILKOVNA_BE_NL_POST_HD,
        ZASILKOVNA_BG_ECONT_HD,
        ZASILKOVNA_BG_ECONT_PP,
        ZASILKOVNA_BG_SPEEDY_PP,
        ZASILKOVNA_BG_SPEEDY_HD,
        ZASILKOVNA_BG_ECONT_BOX,
        ZASILKOVNA_CZ_POST_HD,
        ZASILKOVNA_CZ_EXPRESS_PRAHA_HD,
        ZASILKOVNA_CZ_EXPRESS_BRNO_HD,
        ZASILKOVNA_CZ_EXPRESS_OSTRAVA_HD,
        ZASILKOVNA_CZ_COURIER_HD,
        ZASILKOVNA_DE_POST_HD,
        ZASILKOVNA_DE_HERMES_PP,
        ZASILKOVNA_DE_HERMES_HD,
        ZASILKOVNA_DE_HOME_DELIVERY_HD,
        ZASILKOVNA_DK_POST_NORD_HD,
        ZASILKOVNA_DK_POST_NORD_PP,
        ZASILKOVNA_DK_DAO_HD,
        ZASILKOVNA_DK_DAO_PP,
        ZASILKOVNA_EE_OMNIVA_HD,
        ZASILKOVNA_EE_OMNIVA_PP,
        ZASILKOVNA_EE_OMNIVA_BOX,
        ZASILKOVNA_ES_CORREOS_HD,
        ZASILKOVNA_ES_MRW_HD,
        ZASILKOVNA_ES_MRW_PP,
        ZASILKOVNA_FI_POST_NORD_HP,
        ZASILKOVNA_FI_POST_NORD_PP,
        ZASILKOVNA_FR_COLIS_PRIVE_HD,
        ZASILKOVNA_FR_MONDIAL_PP,
        ZASILKOVNA_FR_COLISSIMO_PP,
        ZASILKOVNA_FR_COLISSIMO_HD,
        ZASILKOVNA_GB_HERMES_HD,
        ZASILKOVNA_GB_ROYAL_MAIL_24_HD,
        ZASILKOVNA_GB_ROYAL_MAIL_48_HD,
        ZASILKOVNA_GR_TAXYDROMIKI,
        ZASILKOVNA_GR_ACS_HD,
        ZASILKOVNA_GR_ACS_PP,
        ZASILKOVNA_GR_SPEEDY_HD,
        ZASILKOVNA_HR_OVERSEAS_HD,
        ZASILKOVNA_HR_OVERSEAS_PP,
        ZASILKOVNA_HR_DPD_HD,
        ZASILKOVNA_HR_POST_PP,
        ZASILKOVNA_HR_POST_HD,
        //ZASILKOVNA_HU_EXPRESS_ONE_HD,
        ZASILKOVNA_HU_DPD_HD,
        ZASILKOVNA_HU_COURIER_HD,
        ZASILKOVNA_HU_POST_HD,
        ZASILKOVNA_CH_POST_PRIORITY_HD,
        ZASILKOVNA_CH_POST_HD,
        // ZASILKOVNA_IE_HERMES_HD,
        ZASILKOVNA_IE_ANPOST_HD,
        ZASILKOVNA_IT_BARTOLINI_HD,
        ZASILKOVNA_IT_BARTOLINI_PP,
        ZASILKOVNA_IT_GLS_HD,
        ZASILKOVNA_LT_OMNIVA_BOX,
        ZASILKOVNA_LT_OMNIVA_HD,
        ZASILKOVNA_LU_POST_HD,
        ZASILKOVNA_LU_DPD_HD,
        ZASILKOVNA_LV_OMNIVA_BOX,
        ZASILKOVNA_LV_OMNIVA_HD,
        ZASILKOVNA_NL_DHL_HD,
        ZASILKOVNA_NL_POST_HD,
        ZASILKOVNA_NL_DHL_PP,
        ZASILKOVNA_PL_POST_24_HD,
        ZASILKOVNA_PL_POST_48_HD,
        ZASILKOVNA_PL_DPD_HD,
        ZASILKOVNA_PL_COURIER_HD,
        ZASILKOVNA_PL_INPOST_PACZKOMATY_BOX,
        ZASILKOVNA_PL_INPOST_HD,
        ZASILKOVNA_PT_MRW_HD,
        ZASILKOVNA_PT_MRW_PP,
        ZASILKOVNA_RO_COURIER_HD,
        ZASILKOVNA_RO_URGENT_CARGUS_HD,
        ZASILKOVNA_RO_SAMEDAY_BOX,
        ZASILKOVNA_RO_DPD_HD,
        ZASILKOVNA_RO_SAMEDAY_HD,
        ZASILKOVNA_RO_FAN_COURIER_HD,
        ZASILKOVNA_RU_POST_PP,
        ZASILKOVNA_RU_POST_RECOMMENDED_PP,
        ZASILKOVNA_RU_EMS_HD,
        ZASILKOVNA_SE_POST_NORD_PP,
        ZASILKOVNA_SE_POST_NORD_HD,
        ZASILKOVNA_SI_DPD_HD,
        ZASILKOVNA_SI_DPD_PP,
        ZASILKOVNA_SI_POST_HD,
        ZASILKOVNA_SI_POST_PP,
        ZASILKOVNA_SI_POST_BOX,
        ZASILKOVNA_SK_EXPRESS_BRATISLAVA_HD,
        ZASILKOVNA_SK_COURIER_HD,
        ZASILKOVNA_SK_POST_HD,
        ZASILKOVNA_UA_NOVA_POSHTA_PP,
        ZASILKOVNA_UA_ROSAN_HD,
        ZASILKOVNA_US_FEDEX_ECONOMY_HD,
        ZASILKOVNA_US_FEDEX_PRIORITY_HD);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> tnt() {
    return Arrays.asList(
        TNT_EXPRESS,
        TNT_EXPRESS_9,
        TNT_EXPRESS_12,
        TNT_ECONOMY_EXPRESS,
        TNT_NIGHT_EXPRESS_8,
        TNT_ECONOMY_EXPRESS_12,
        TNT_EXPRESS_10,
        TNT_EXPRESS_DOCUMENTS,
        TNT_EXPRESS_DOCUMENTS_9,
        TNT_EXPRESS_DOCUMENTS_10,
        TNT_EXPRESS_DOCUMENTS_12,
        TNT_NIGHT_EXPRESS_12,
        TNT_NIGHT_EXPRESS_6,
        TNT_NIGHT_EXPRESS_7,
        TNT_NIGHT_EXPRESS_14,
        TNT_SPECIAL_ECONOMY_EXPRESS,
        TNT_DIRECT_INFEED);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> gw() {
    return Arrays.asList(
        GW_DOMESTIC,
        GW_HOME_DELIVERY,
        GW_PRIORITY_9,
        GW_PRIORITY_12,
        GW_PRIORITY_16,
        GW_DIRECT_GOODS,
        GW_EXPORT,
        GW_PICKUP,
        GW_PICKUP_BY_CONSIGNEE);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> gwcz() {
    return Arrays.asList(
        GW_W24,
        GW_D8,
        GW_D12,
        GW_D14,
        GW_EUR);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> messenger() {
    return Arrays.asList(
        MESSENGER_STANDARD,
        MESSENGER_EXTREME,
        MESSENGER_EXPRESS,
        MESSENGER_SAME_DAY,
        MESSENGER_OVERNIGHT_ECONOMY,
        MESSENGER_OVERNIGHT_EXPRESS,
        MESSENGER_DIRECT,
        MESSENGER_PRAGUE_09_13,
        MESSENGER_PRAGUE_13_17,
        MESSENGER_PRAGUE_17_21);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dhlde() {
    return Arrays.asList(
        DHLDE_PAKET,
        DHLDE_PAKET_TAGGLEICH,
        DHLDE_PAKET_INTERNATIONAL,
        DHLDE_EUROPAKET,
        DHLDE_PAKET_CONNECT);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> fedex() {
    return Arrays.asList(
        FEDEX_INTERNATIONAL,
        FEDEX_ECONOMY);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> fofr() {
    return Arrays.asList(
        FOFR_FOFR,
        FOFR_ECONOMY,
        FOFR_PARCEL,
        FOFR_PALETTE,
        FOFR_OVERSIZED,
        FOFR_SK,
        FOFR_ABROAD);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dachser() {
    return Arrays.asList(
        DACHSER_SPEED,
        DACHSER_SPEED_10,
        DACHSER_SPEED_12,
        DACHSER_SPEED_PLUS,
        DACHSER_FIX,
        DACHSER_FIX_10,
        DACHSER_FIX_12,
        DACHSER_FLEX,
        DACHSER_ONSITE,
        DACHSER_CLASSIC);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dhlparcel() {
    return Collections.singletonList(
        DHLPARCEL_CONNECT);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> raben() {
    return Arrays.asList(
        RABEN_CLASSIC,
        RABEN_CLASSIC_TIME,
        RABEN_PREMIUM,
        RABEN_PREMIUM_TIME,
        RABEN_PREMIUM_12,
        RABEN_PREMIUM_FIX);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> spring() {
    return Arrays.asList(
        SPRING_TRACKED,
        SPRING_SIGNATURED,
        SPRING_UNTRACKED);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dsv() {
    return Arrays.asList(
        DSV_ROAD,
        DSV_B2C);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dhlfreightec() {
    return Arrays.asList(
        DHLFREIGHTEC_ECD_B2B,
        DHLFREIGHTEC_ECD_B2C,
        DHLFREIGHTEC_ECI,
        DHLFREIGHTEC_ERI);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> kurier() {
    return Arrays.asList(
        KURIER_GARANTED,
        // KURIER_12,
        KURIER_STANDARD);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> dbschenker() {
    return Arrays.asList(
        DBSCHENKER_SYSTEM_FIX,
        DBSCHENKER_SYSTEM_FIX_TBA,
        DBSCHENKER_SYSTEM,
        DBSCHENKER_SYSTEM_PREMIUM,
        DBSCHENKER_SYSTEM_PREMIUM_10,
        DBSCHENKER_SYSTEM_PREMIUM_13,
        DBSCHENKER_SYSTEM_FIX_10,
        DBSCHENKER_SYSTEM_FIX_13,
        DBSCHENKER_FULL_LOAD,
        DBSCHENKER_PART_LOAD);
  }

  /**
   * @return ArrayList<String>
   */
  public static List<ServiceType> airway() {
    return Arrays.asList(
        AIRWAY_EXPRESS,
        AIRWAY_NORMAL,
        AIRWAY_ECONOMY,
        AIRWAY_SAME_DAY,
        AIRWAY_PRAGUE_13,
        AIRWAY_PRAGUE_17,
        AIRWAY_PRAGUE_21,
        AIRWAY_NEXT_DAY,
        AIRWAY_NEXT_WEEKDAY);
  }

  /**
   * All supported shipper services
   *
   * @return ArrayList<String, ArrayList<> < String>>
   */
  public static HashMap<Shipper, List<ServiceType>> all() {
    return new HashMap<Shipper, List<ServiceType>>() {{
      put(Shipper.CP, cp());
      put(Shipper.DPD, dpd());
      put(Shipper.DHL, dhl());
      put(Shipper.GEIS, geis());
      put(Shipper.GLS, gls());
      put(Shipper.INTIME, intime());
      put(Shipper.PBH, pbh());
      put(Shipper.PPL, ppl());
      put(Shipper.SP, sp());
      put(Shipper.SPS, sps());
      put(Shipper.TOPTRANS, topTrans());
      put(Shipper.ULOZENKA, ulozenka());
      put(Shipper.UPS, ups());
      put(Shipper.ZASILKOVNA, zasilkovna());
      put(Shipper.TNT, tnt());
      put(Shipper.GW, gw());
      put(Shipper.GWCZ, gwcz());
      put(Shipper.MESSENGER, messenger());
      put(Shipper.DHLDE, dhlde());
      put(Shipper.FEDEX, fedex());
      put(Shipper.FOFR, fofr());
      put(Shipper.DACHSER, dachser());
      put(Shipper.DHLPARCEL, dhlparcel());
      put(Shipper.RABEN, raben());
      put(Shipper.SPRING, spring());
      put(Shipper.DSV, dsv());
      put(Shipper.DHLFREIGHTEC, dhlfreightec());
      put(Shipper.KURIER, kurier());
      put(Shipper.DBSCHENKER, dbschenker());
      put(Shipper.AIRWAY, airway());
    }};
  }
}
