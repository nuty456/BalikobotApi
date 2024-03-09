package cz.balikobot.api.utils;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

/**
 * Unique identifier.
 */
public class Uniqid {
  /**
   * Generate a unique identifier.
   *
   * @param prefix       The prefix to prepend to the generated identifier. Can be empty.
   * @param more_entropy Whether to generate a more entropy-based identifier. If set to false, a shorter identifier will be generated.
   * @return The generated unique identifier.
   */
  public static String uniqid(String prefix, boolean more_entropy) {
    long time = System.currentTimeMillis();
    String uniqid = "";
    String format = String.format("%s%08x%05x", prefix, time / 1000, time);
    if (!more_entropy) {
      uniqid = format;
    } else {
      SecureRandom sec = new SecureRandom();
      byte[] sbuf = sec.generateSeed(8);
      ByteBuffer bb = ByteBuffer.wrap(sbuf);

      uniqid = format;
      uniqid += "." + String.format("%.8s", "" + bb.getLong() * -1);
    }

    return uniqid;
  }
}
