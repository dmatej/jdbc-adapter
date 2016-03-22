/**
 *
 */
package org.jdbc.adapter.iface;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;

/**
 * A connection wrapper. Wraps also all statements with some {@link StatementWrapper}
 * implementation.
 *
 * @author David Matějček
 */
public interface ConnectionWrapper extends Connection {

  /**
   * @param statement
   * @return a {@link StatementWrapper}
   */
  StatementWrapper wrap(Statement statement);


  /**
   * Wraps a {@link DatabaseMetaData} instance with some {@link DatabaseMetaDataWrapper}
   * implementation.
   *
   * @param metaData
   * @return a {@link DatabaseMetaDataWrapper}
   */
  DatabaseMetaDataWrapper wrap(DatabaseMetaData metaData);
}
