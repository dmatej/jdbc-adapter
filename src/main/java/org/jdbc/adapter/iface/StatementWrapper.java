/**
 *
 */
package org.jdbc.adapter.iface;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * A statement wrapper. Wraps also all result sets with some {@link ResultSetWrapper}
 * implementation.
 *
 * @author David Matějček
 */
public interface StatementWrapper extends CallableStatement {

  /**
   * Wraps a {@link ResultSet} instance with some {@link ResultSetWrapper} implementation.
   *
   * @param resultSet
   * @return a {@link ResultSetWrapper}
   */
  ResultSetWrapper wrap(ResultSet resultSet);
}
