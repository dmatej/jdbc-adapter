package org.jdbc.adapter.conversion;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author David Matějček
 */
public class DefaultTypeConversions {

  public static Object toJdbc30Type(final Object value) {
    if (value instanceof LocalDateTime) {
      return Timestamp.valueOf((LocalDateTime) value);
    } else if (value instanceof LocalDate) {
      return Date.valueOf((LocalDate) value);
    }
    return value;
  }
}
