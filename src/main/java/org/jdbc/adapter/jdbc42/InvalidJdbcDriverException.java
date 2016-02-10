package org.jdbc.adapter.jdbc42;

/**
 * Cannot find valid JDBC driver.
 *
 * @author David Matějček
 */
public class InvalidJdbcDriverException extends RuntimeException {

  private static final long serialVersionUID = -3245050139693909203L;


  /**
   * @param message
   */
  public InvalidJdbcDriverException(final String message) {
    super(message);
  }


  /**
   * @param message
   * @param cause
   */
  public InvalidJdbcDriverException(final String message, final Exception cause) {
    super(message, cause);
  }
}
