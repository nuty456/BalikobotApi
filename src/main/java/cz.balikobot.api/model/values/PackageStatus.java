package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Data
@Slf4j
public class PackageStatus {
  /**
   *
   */
  private Double id;

  /**
   *
   */
  private String status;

  /**
   *
   */
  private String statusV2;

  /**
   *
   */
  private String name;

  /**
   *
   */
  private String description;

  /**
   *
   */
  private String type;

  /**
   * @var \DateTime|null
   */
  private DateTime date;

  /**
   * PackageStatus constructor
   *
   * @param id
   * @param type
   * @param name
   * @param description
   */
  public PackageStatus(Double id, String type, String name, String description) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.description = description;
    this.date = null;
  }

  /**
   * PackageStatus constructor
   *
   * @param id
   * @param type
   * @param name
   * @param description
   * @param date
   */
  public PackageStatus(Double id, String type, String name, String description, DateTime date) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.description = description;
    this.date = date;
  }

  public PackageStatus(Double id, String status, String statusV2, String type, String description, String name, DateTime date) {
    this.id = id;
    this.status = status;
    this.statusV2 = statusV2;
    this.name = name;
    this.description = description;
    this.type = type;
    this.date = date;
  }

  /**
   * @return int
   */
  public int getGroupId() {
    return this.id.intValue();
  }

  /**
   * @param data
   * @return \Inspirum\Balikobot\Model\Values\PackageStatus
   */
  public static PackageStatus newInstanceFromData(HashMap<Object, Object> data) {
    DateTime date = null;
    try {
      if (data.containsKey("date")) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime((String) data.get("date"));
        date = dt;
      }
    } catch (Throwable exception) {
      date = null;
    }

    final Object statusSource = data.containsKey("status_id_v2") ? data.get("status_id_v2") : data.get("status_id");
    Double id = 0.0;
    try {
      if (statusSource != null) {
        if (statusSource instanceof Double) {
          id = (Double) statusSource;
        } else if (statusSource instanceof Integer) {
          id = new Double((Integer) statusSource);
        } else if (statusSource instanceof String) {
          id = Double.parseDouble((String) statusSource);
        }
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    final Object status1Source = data.getOrDefault("status_id", null);
    String status = null;
    try {
      if (status1Source != null) {
        if (status1Source instanceof Double) {
          status = Double.toString((Double) status1Source);
        } else if (status1Source instanceof Integer) {
          status = Integer.toString((Integer) status1Source);
        } else if (status1Source instanceof String) {
          status = (String) status1Source;
        }
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    final Object statusV2Source = data.getOrDefault("status_id_v2", null);
    String statusV2 = null;
    try {
      if (statusV2Source != null) {
        if (statusV2Source instanceof Double) {
          statusV2 = Double.toString((Double) statusV2Source);
        } else if (statusV2Source instanceof Integer) {
          statusV2 = Integer.toString((Integer) statusV2Source);
        } else if (statusV2Source instanceof String) {
          statusV2 = (String) statusV2Source;
        }
      }
    } catch (Exception e) {
      log.error(String.format("Exception: %s", e.getMessage()), e);
    }

    return new PackageStatus(
        id,
        status,
        statusV2,
        data.get("type") != null ? (String) data.get("type") : "event",
        data.containsKey("name_balikobot") ? (String) data.get("name_balikobot") : (data.containsKey("name_internal") ? (String) data.get("name_internal") : (String) data.get("name")),
        (String) data.get("name"),
        date
    );
  }

}
