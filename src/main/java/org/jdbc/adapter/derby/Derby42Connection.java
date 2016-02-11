package org.jdbc.adapter.derby;

import java.sql.Connection;
import java.sql.Statement;

import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Connection;

/**
 * @author David Matějček
 */
public class Derby42Connection extends Jdbc42Connection {

  public Derby42Connection(Connection connection) {
    super(connection);
  }


  /**
   * @param statement
   * @return a {@link Derby42Statement} instance.
   */
  @Override
  public StatementWrapper wrap(final Statement statement) {
    if (statement == null) {
      return null;
    }
    return new Derby42Statement(statement, this);
  }
}
