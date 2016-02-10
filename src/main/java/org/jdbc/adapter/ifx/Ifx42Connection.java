package org.jdbc.adapter.ifx;

import java.sql.Connection;
import java.sql.Statement;

import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Connection;

/**
 * @author David Matějček
 */
public class Ifx42Connection extends Jdbc42Connection {

  public Ifx42Connection(Connection connection) {
    super(connection);
  }


  /**
   * @param statement
   * @return a {@link Ifx42Statement} instance.
   */
  @Override
  public StatementWrapper wrap(final Statement statement) {
    if (statement == null) {
      return null;
    }
    return new Ifx42Statement(statement, this);
  }
}
