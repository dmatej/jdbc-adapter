package org.jdbc.adapter.version;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

/**
 * Checks if the connection implements some selected methods and returns the JDBC spec version.
 * TODO: find better approach.
 *
 * @author David Matějček
 */
public enum JDBCVersion {
  /** JDBC 4.2 */
  JDBC4_2,
  /** JDBC 4.0 */
  JDBC4,
  /** JDBC 3.0 */
  JDBC3;

  /**
   * If the connection implements isWrapperFor, it probably implements JDBC4.
   *
   * @param connection
   * @return {@link JDBCVersion}
   */
  public static JDBCVersion getVersion(final Connection connection) {

    try {
      connection.getNetworkTimeout();
      return JDBC4_2;
    } catch (final SQLFeatureNotSupportedException e) {
      // okay, driver does not support this feature, but still implements JDBC 4.1.
      return JDBC4_2;
    } catch (final SQLException | AbstractMethodError e) {
      // nothing
    }

    try {
      // Glassfish's ConnectionHolder40 and ConnectionWrapper40 will success with
      // wrappers, but not with getClientInfo.
      connection.getClientInfo();
      connection.isWrapperFor(Connection.class);
      connection.unwrap(Connection.class);
      return JDBC4;
    } catch (final SQLFeatureNotSupportedException e) {
      return JDBC4;
    } catch (final SQLException | AbstractMethodError e) {
      return JDBC3;
    }
  }

}
