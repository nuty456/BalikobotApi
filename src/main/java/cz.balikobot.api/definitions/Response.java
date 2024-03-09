package cz.balikobot.api.definitions;

import java.util.HashMap;

import lombok.Data;

/**
 * Defined responses.
 */
@Data
public class Response {
  /**
   * ArrayList<int,String>
   */
  public static HashMap<Integer, String> statusCodesErrors = new HashMap<Integer, String>() {{
    put(200, "OK, operace proběhla v pořádku.");
    put(208, "Položka s doloženým ID již existuje. Data, která jsou navrácena, patří k původnímu záznamu.");
    put(400, "Operace neproběhla v pořádku, zkontrolujte konkrétní data.");
    put(401, "Unauthorized - nejspíš chyba na straně Balikobotu");
    put(403, "Přepravce není pro použité klíče aktivovaný.");
    put(404, "Zásilka neexistuje, nebo již byla zpracována.");
    put(406, "Nedorazila žádná data ke zpracování nebo nemůžou být akceptována.");
    put(409, "Konfigurační soubor daného dopravce nebo profil není vyplněn/konflikt mezi přijatými daty u zásilky.");
    put(413, "Špatný formát dat.");
    put(423, "Tato funkce je dostupná jen pro \"živé klíče\".");
    put(501, "Technologie toho dopravce ještě není implementována, pro bližší informace sledujte web balikobot.cz.");
    put(503, "Technologie dopravce není dostupná, požadavek bude vyřízen později.");
    put(500, "Nepodařilo se rozeznat chybový stav.");
  }};

  /**
   * ArrayList<int,String>
   */
  public static HashMap<Integer, String> packageDataErrors = new HashMap<Integer, String>() {{
    put(406, "Nedorazila žádná data ke zpracování.");
    put(409, "Nepovolená kombinace služeb dobírky a výměnné zásilky.");
    put(413, "Špatný formát dat.");
    put(416, "Datum má špatný formát nebo není povoleno.");
  }};

  /**
   * ArrayList<int,ArrayList<String,String>>
   */
  public static HashMap<Integer, HashMap<String, String>> packageDataKeyErrors = new HashMap<Integer, HashMap<String, String>>() {{
    put(406, new HashMap<String, String>() {{
          put("eid", "Nedorazilo eshop ID.");
          put("service_type", "Nedorazilo ID vybrané služby přepravce.");
          put("cod_currency", "Nedorazil ISO kód měny.");
          put("branch_id", "Nedorazilo ID pobočky.");
          put("rec_name", "Nedorazilo jméno příjemce.");
          put("rec_street", "Nedorazila ulice s číslem popisným příjemce.");
          put("rec_city", "Nedorazilo město příjemce.");
          put("rec_zip", "Nedorazilo PSČ příjemce.");
          put("rec_country", "Nedorazil ISO kód země příjemce.");
          put("rec_phone", "Nedorazilo telefonní číslo příjemce.");
          put("rec_email", "Nedorazil email příjemce.");
          put("price", "Nedorazila udaná cena zásilky.");
          put("vs", "Nedorazil variabilní symbol pro dobírkovou zásilku.");
          put("service_range", "Balíček nelze přidat, protože není vyplněna číselná řada v klientské zóně.");
          put("config_data", "Balíček nelze přidat, protože chybí potřebná data v klientské zóně.");
          put("weight", "Nedorazil údaj o váze zásilky.");
        }}
    );
    put(409, new HashMap<String, String>() {{
          put("cod_price", "Nepovolená kombinace služeb dobírky a výměnné zásilky.");
          put("swap", "Nepovolená kombinace služeb dobírky a výměnné zásilky.");
        }}
    );
    put(413, new HashMap<String, String>() {{
          put("eid", "Eshop ID je delší než je maximální povolená délka.");
          put("service_type", "Neznámé ID služby přepravce.");
          put("cod_price", "Nepovolená dobírka.");
          put("cod_currency", "Nepovolený ISO kód měny.");
          put("price", "Nepovolená částka udané ceny.");
          put("branch_id", "Neznámé ID pobočky.");
          put("rec_email", "Špatný formát emailu příjemce.");
          put("order_number", "Sdružená zásilka není povolena.");
          put("rec_country", "Nepovolený ISO kód země příjemce.");
          put("rec_zip", "Nepovolené PSČ příjemce.");
          put("weight", "Neplatný formát váhy/váha překračuje maximální povolenou hodnotu.");
          put("swap", "Výměnná zásilka není pro vybranou službu povolena.");
          put("rec_phone", "Špatný formát telefonního čísla.");
          put("credit_card", "Platba kartou není pro tuto službu/pobočku povolena.");
          put("service_range", "Balíček nelze přidat, protože číselná řada v klientské zóně je již přečerpaná.");
        }}
    );
    put(416, new HashMap<String, String>() {{
          put("delivery_date", "Datum má špatný formát nebo není povoleno.");
        }}
    );
  }};
}
