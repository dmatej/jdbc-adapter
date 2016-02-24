package org.jdbc.adapter.ifx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.concurrent.Executor;

import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Connection;

import com.informix.jdbc.IfmxConnection;

/**
 * @author David Matějček
 */
public class Ifx42Connection extends Jdbc42Connection {

  public Ifx42Connection(final Connection connection) {
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


  /**
   * @return the wrapped connection;
   */
  @Override
  protected final IfmxConnection getConnection() {
    return IfmxConnection.class.cast(getConnection());
  }


  @Override
  public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
    throw new SQLFeatureNotSupportedException(
        "This driver does not support the setNetworkTimeout(Executor executor, int milliseconds)");
  }


  @Override
  public int getNetworkTimeout() throws SQLException {
    throw new SQLFeatureNotSupportedException("This driver does not support the getNetworkTimeout()");
  }
}
