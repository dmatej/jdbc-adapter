/**
 *
 */
package org.jdbc.adapter.iface;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A database metadata wrapper.
 *
 * @author David Matějček
 */
public interface DatabaseMetaDataWrapper extends DatabaseMetaData {

  /**
   * Wraps a {@link ResultSet} instance with some {@link ResultSetWrapper} implementation.
   *
   * @param resultSet
   * @return a {@link ResultSetWrapper}
   * @throws SQLException
   */
  ResultSetWrapper wrap(ResultSet resultSet) throws SQLException;


  /**
   * @param statement
   * @return a {@link StatementWrapper}
   * @throws SQLException
   */
  StatementWrapper wrap(Statement statement) throws SQLException;

}
