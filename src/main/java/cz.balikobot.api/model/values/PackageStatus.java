package cz.balikobot.api.model.values;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * A class that represents the status of a package.
 */
@Data
@Slf4j
@AllArgsConstructor
public class PackageStatus {
  /**
   * ID.
   */
  private Double id;

  /**
   * The current status.
   */
  private String status;

  /**
   * Represents the status version 2.
   */
  private String statusV2;

  /**
   * Name.
   */
  private String name;

  /**
   * Description.
   */
  private String description;

  /**
   * Type.
   */
  private String type;

  /**
   * Date.
   */
  private DateTime date;

  /**
   * Represents the status of a package.
   *
   * @param id          the identifier of the package status
   * @param type        the type of the package status
   * @param name        the name of the package status
   * @param description the description of the package status
   */
  public PackageStatus(Double id, String type, String name, String description) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.description = description;
    this.date = null;
  }

  /**
   * Initializes a new instance of the PackageStatus class with the specified parameters.
   *
   * @param id          The identifier of the package status.
   * @param type        The type of the package status.
   * @param name        The name of the package status.
   * @param description The description of the package status.
   * @param date        The date of the package status.
   */
  public PackageStatus(Double id, String type, String name, String description, DateTime date) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.description = description;
    this.date = date;
  }

  /**
   * Returns the group ID.
   *
   * @return the group ID as an integer
   */
  public int getGroupId() {
    return this.id.intValue();
  }

  /**
   * Creates a new PackageStatus instance based on the given data.
   *
   * @param data The data used to create the PackageStatus instance. The data is expected to be a HashMap<Object, Object> object.
   * @return A new PackageStatus instance created from the given data.
   */
  public static PackageStatus newInstanceFromData(HashMap<Object, Object> data) {
    DateTime date = null;
    try {
      if (data.containsKey("date")) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        date = formatter.parseDateTime((String) data.get("date"));
      }
    } catch (Throwable exception) {
      date = null;
    }

    final Object statusSource = data.containsKey("status_id_v2") ? data.get("status_id_v2") : data.get("status_id");
    double id = 0.0;
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
